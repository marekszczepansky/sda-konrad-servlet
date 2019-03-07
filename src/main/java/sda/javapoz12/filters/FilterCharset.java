package sda.javapoz12.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "FilterCharset", urlPatterns = {"/task/*", "/actionServlet"}, dispatcherTypes = DispatcherType.REQUEST)
public class FilterCharset implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String clientIp = req.getRemoteAddr();
        String requestPath = "unknown";
        String servletPath = "unknown";

        if (req instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) req;
            servletPath = httpServletRequest.getServletPath();
            requestPath = httpServletRequest.getMethod() + " " + httpServletRequest.getRequestURL().toString();
            if (httpServletRequest.getQueryString() != null) {
                requestPath += "?" + httpServletRequest.getQueryString();
            }
        }

        System.out.println(clientIp + " requests start for " + requestPath);
        System.out.println("servlet path matched " + servletPath);

        chain.doFilter(req, resp);

        System.out.println(clientIp + " requests end for " + requestPath);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
