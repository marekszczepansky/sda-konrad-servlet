package sda.javapoz12.user;

import sda.javapoz12.dal.UsersDAO;
import sda.javapoz12.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task/doEdit")
public class DoEditServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDAO usersDAO = (UsersDAO) getServletContext().getAttribute("UsersDAO");
        User user = new User(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("surname"),
                Integer.parseInt(request.getParameter("age")),
                request.getParameter("email")
        );

        usersDAO.update(user);
        response.sendRedirect("doList");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UsersDAO usersDAO = (UsersDAO) getServletContext().getAttribute("UsersDAO");
        Integer id = Integer.parseInt(request.getParameter("id"));

        User user = usersDAO.getById(id);

        if (user == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
        } else {
            request.setAttribute("user", user);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        }
    }
}