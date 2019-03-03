package sda.javapoz12;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet("/actionServlet")
public class ActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String clientIp = request.getRemoteAddr();
        String testName = request.getParameter("name");
        String browser = request.getHeader("User-Agent");

        PrintWriter out = response.getWriter();
        String title = "Using POST Method to Read Form Data";
        String docType = "<!doctype html>\n";

        out.println(docType +
                "<html lang=\"pl\">\n" +
                "<head><meta charset=\"UTF-8\"><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<p> Client IP " + clientIp + "</p>" +
                "<p> Client name " + testName + "</p>" +
                "<p> Client agent " + browser + "</p>" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<ul>\n");


        request.getParameterMap().forEach((name, values) -> {
            out.println(" <li><strong>" + name + "</strong>: " + Arrays.toString(values));
        });
        out.println("</ul>\n" +
                "</body>" +
                "</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
