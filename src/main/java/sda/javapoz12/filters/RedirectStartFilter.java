package sda.javapoz12.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebFilter(filterName = "Redirect to start", urlPatterns = "/task/*")
public class RedirectStartFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        boolean visited = false;

        if (req instanceof HttpServletRequest) {
            HttpServletRequest request;
            request = (HttpServletRequest) req;

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                visited = Arrays.stream(cookies).anyMatch(cookie -> "visited".equals(cookie.getName()) && "yes".equals(cookie.getValue()));
            }
        }

        if (resp instanceof HttpServletResponse) {
            HttpServletResponse response;
            response = (HttpServletResponse) resp;

            if (!visited) {
                response.sendRedirect("/servletWar/");
                System.out.println("forced redirect to index.jsp");
            }
        }

        if (visited) {
            System.out.println("cookie found index.jsp");
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }
}