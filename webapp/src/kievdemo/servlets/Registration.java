package kievdemo.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class Registration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, ServletException, IOException {
        String login = request.getParameter("login");
        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");

        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kiev_demo_db", "root", "1234")) {
            if (connection != null) {
                Statement statement = connection.createStatement();

                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE login = '" + login + "';")) {
                    if (!resultSet.next() && pass1.equals(pass2)) {
                        statement.executeUpdate("INSERT INTO users (login, password) VALUES ('" + login + "', '" + pass1 + "');");

                        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
                    } else {
                        getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
                    }
                }
            } else {
                getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}