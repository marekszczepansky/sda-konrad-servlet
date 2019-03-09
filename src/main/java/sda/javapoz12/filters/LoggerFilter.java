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
import java.time.LocalDateTime;
import java.time.LocalTime;

// TODO: dodać kod wyświetlający na konsoli rozpoczęcie i zakończenie requestu z podaniem czasu, metody, url i adresu IP
//       httpServletRequest.getRequestURL().toString(),httpServletRequest.getQueryString()
//       metody: GET, POST

// TODO: dla ambitnych - zbudować filter który pozwoli wykonać tylko żądania z IP 127.0.0.1 a innym zwróci status 401


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