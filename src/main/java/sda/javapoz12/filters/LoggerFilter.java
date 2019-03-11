package sda.javapoz12.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

@WebFilter(filterName = "Logger", urlPatterns = "/task/*")
public class LoggerFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String remoteIp;
        String requestedUrl = "unknown";

        if (req instanceof HttpServletRequest) {
            HttpServletRequest request;
            request = (HttpServletRequest) req;
            remoteIp = request.getRemoteAddr();
            String queryString = request.getQueryString();
            requestedUrl = " - remote client: " +
                    remoteIp + " request url: " +
                    request.getMethod() + " - " + request.getRequestURL().toString() +
                    (queryString == null ? "" : "?" + queryString);
        }

        System.out.println(LocalDateTime.now() + requestedUrl);

        chain.doFilter(req, resp);

        System.out.println(LocalDateTime.now() + " request finished");

    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}