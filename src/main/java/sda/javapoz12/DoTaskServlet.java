package sda.javapoz12;

import sda.javapoz12.dal.UsersDAO;
import sda.javapoz12.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task/doTask")
public class DoTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        User user = new User(
                request.getParameter("name"),
                request.getParameter("surname"),
                Integer.parseInt(request.getParameter("age")),
                request.getParameter("email")
        );

        System.out.println("DoTaskServlet post from " + request.getRemoteAddr());
        System.out.println("User created " + user);

        UsersDAO.getInstance().save(user);

        response.sendRedirect("doList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String surname = request.getParameter("surname");

        User user = UsersDAO.getInstance().getByName(surname);

        System.out.println("DoTaskServlet GET from " + request.getRemoteAddr());
        System.out.println("User read " + user);

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("User read " + user);
    }
}