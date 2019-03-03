package sda.javapoz12;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "FilterCharset", urlPatterns = {"/task/*", "/actionServlet"})
public class FilterCharset implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String clientIp = req.getRemoteAddr();
        String requestPath = "unknown";

        if (req instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) req;
            requestPath = httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURL().toString();
            if (httpServletRequest.getQueryString() != null) {
                requestPath += "?" + httpServletRequest.getQueryString();
            }
        }

        System.out.println(clientIp + " requests start for " + requestPath);

        chain.doFilter(req, resp);

        System.out.println(clientIp + " requests end for " + requestPath);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
