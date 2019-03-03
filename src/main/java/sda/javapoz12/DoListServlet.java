package sda.javapoz12;

import sda.javapoz12.dal.UsersDAO;
import sda.javapoz12.domain.User;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
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
        Collection<User> users = UsersDAO.getInstance().getAll();

        ServletOutputStream outputStream = response.getOutputStream();

        for (User user : users) {
            outputStream.println(user.toString());
        }

    }
}