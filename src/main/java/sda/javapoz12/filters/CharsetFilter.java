package sda.javapoz12.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CharsetFilter", urlPatterns = "/task/*")
public class CharsetFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // przed wywołaniem servletu

        if (req instanceof HttpServletRequest) {
            HttpServletRequest request;
            request = (HttpServletRequest) req;
            request.setCharacterEncoding("UTF-8");
        }

        if (resp instanceof HttpServletResponse) {
            HttpServletResponse response;
            response = (HttpServletResponse) resp;
            response.setCharacterEncoding("UTF-8");
        }

        chain.doFilter(req, resp);
        // po wywołaniu servletu

    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}