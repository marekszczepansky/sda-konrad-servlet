package sda.javapoz12;

import sda.javapoz12.dal.UsersDAO;
import sda.javapoz12.dal.UsersDAOJpa;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CustomServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        UsersDAO instance = UsersDAOJpa.getInstance();
        System.out.println("UsersDAO context instance created");
        context.setAttribute("UsersDAO", instance);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* Some method that cleanly destroys
         * your entity manager factory */
//        closeEntityManagerFactory();
    }
}
