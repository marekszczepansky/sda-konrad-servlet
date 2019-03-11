package sda.javapoz12.user;

import sda.javapoz12.dal.UsersDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/task/doDelete")
public class DoTaskDeleteServlet extends HttpServlet {
    private UsersDAO usersDAO;

    public void init() {
        usersDAO = (UsersDAO) getServletContext().getAttribute("UsersDAO");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        usersDAO.delete(id);

        response.sendRedirect("doList");
    }
}