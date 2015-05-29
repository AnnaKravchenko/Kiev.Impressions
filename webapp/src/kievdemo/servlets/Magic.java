package kievdemo.servlets;

import org.kievdemo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Magic extends HttpServlet {
    private ArrayList<User> users;

    @Override
    public void init() throws ServletException {
        super.init();
        users = new ArrayList<>();

        users.add(new User("Fyodor", "0000"));
        users.add(new User("Anton", "1111"));
        users.add(new User("Asd", "1234"));
        users.add(new User("Masha", "0011"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");

        if (command.equals("signin")) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            User user = new User(login, password);

            if (users.contains(user)) {
                request.getSession().setAttribute("login", login);

                request.getSession().setAttribute("user", user);

                getServletContext().getRequestDispatcher("/welcome.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } else if (command.equals("signout")) {
            request.getSession().invalidate();
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
