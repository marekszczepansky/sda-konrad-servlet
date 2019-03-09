package sda.javapoz12.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Start page", urlPatterns = "/index.jsp")
public class StartPageFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);

        if (resp instanceof HttpServletResponse) {
            HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
            Cookie cookie = new Cookie("visited", "yes");
            httpServletResponse.addCookie(cookie);
        }
    }

    public void init(FilterConfig config) throws ServletException { }

    public void destroy() {
    }
}