package sda.javapoz12.user;

import sda.javapoz12.dal.UsersDAOJpa;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Collection<User> users = UsersDAOJpa.getInstance().getAll();
        request.setAttribute("users", users);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}