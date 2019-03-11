package sda.javapoz12.user;

import sda.javapoz12.dal.UsersDAO;
import sda.javapoz12.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet("/task/doList")
public class DoListServlet extends HttpServlet {

    private UsersDAO usersDAO;

    public void init() {
        usersDAO = (UsersDAO) getServletContext().getAttribute("UsersDAO");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Collection<User> users = usersDAO.getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}