package sda.javapoz12.user;

import sda.javapoz12.dal.UsersDAO;
import sda.javapoz12.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@WebServlet("/task/doList")
public class DoListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Collection<User> users = UsersDAO.getInstance().getAll();

//        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter outputStream = response.getWriter();
        outputStream.println("<a href=\"index.html\">Dodaj nowy</a></br>");

        for (User user : users) {
            outputStream.println("<a href=\"doTask?id=" + user.getId() + "\">" + user.toString() + "</a>");
            outputStream.println(" <a href=\"doDelete?id=" + user.getId() + "\">Usuń</a></br>");
        }

    }
}