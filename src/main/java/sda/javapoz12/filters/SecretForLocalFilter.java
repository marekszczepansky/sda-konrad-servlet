package sda.javapoz12.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
filter order
https://stackoverflow.com/questions/6560969/how-to-define-servlet-filter-order-of-execution-using-annotations-in-war
 */
@WebFilter(filterName = "Secret for local", urlPatterns = "/secret/*")
public class SecretForLocalFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if (!"127.0.0.1".equals(req.getRemoteAddr())) {
            if (resp instanceof HttpServletResponse) {
                HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
                httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "You shall not pass!");
                System.out.println(req.getRemoteAddr() + " rejected!");
            }
            return;
        }

        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }
}