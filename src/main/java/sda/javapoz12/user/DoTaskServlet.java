package sda.javapoz12.user;

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
    private UsersDAO usersDAO;

    public void init() {
        usersDAO = (UsersDAO) getServletContext().getAttribute("UsersDAO");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(
                request.getParameter("name"),
                request.getParameter("surname"),
                Integer.parseInt(request.getParameter("age")),
                request.getParameter("email")
        );

        System.out.println("User created " + user);

        usersDAO.save(user);

        response.sendRedirect("doList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        User user = usersDAO.getById(id);

        System.out.println("User read " + user);

        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("User", user);

        request.getRequestDispatcher("show.jsp").forward(request, response);
    }
}