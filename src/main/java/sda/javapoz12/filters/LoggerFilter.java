package sda.javapoz12.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalTime;

// TODO: dodać kod wyświetlający na konsoli rozpoczęcie i zakończenie requestu z podaniem url i adresu IP
//       httpServletRequest.getRequestURL().toString(),httpServletRequest.getQueryString()


@WebFilter(filterName = "Logger", urlPatterns = "/task/*")
public class LoggerFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String remoteIp = "unknown";

        if (req instanceof HttpServletRequest) {
            HttpServletRequest request;
            request = (HttpServletRequest) req;
            remoteIp = request.getRemoteAddr();
        }

        System.out.println("request from remote: " + remoteIp);

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException { }

    public void destroy() {   }
}