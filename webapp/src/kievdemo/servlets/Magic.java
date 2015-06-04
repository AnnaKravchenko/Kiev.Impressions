package kievdemo.servlets;

import org.kievdemo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
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
        try {
            process(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException {
        String command = request.getParameter("command");

        if (command.equals("signin")) {
            String login = request.getParameter("login");
            String password = request.getParameter("password");


            if (auth(login, password)) {
                User user = new User(login, password);

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

    private boolean auth(String login, String password) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kiev_demo_db", "root", "1234")) {
            if (connection != null) {
                Statement statement = connection.createStatement();

                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM kiev_demo_db.users WHERE login='" + login + "';")) {
                    return resultSet.next() && resultSet.getString("password").equals(password);
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
