package kievdemo.servlets;

import org.kievdemo.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Map;

public class Choice extends HttpServlet {
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
        Map<String, String[]> checkedEvents = request.getParameterMap();

        final int RATE = 5;

        int count = checkedEvents.get("isChecked") == null ? 0 : checkedEvents.get("isChecked").length;

        for (int i = 0; i < count; i++) {
            int index = Integer.parseInt(checkedEvents.get("isChecked")[i]);

            String name = checkedEvents.get("name")[index];
            double cost = Double.parseDouble(checkedEvents.get("cost")[index]);
            String description = checkedEvents.get("description")[index];
            String tag = checkedEvents.get("tag")[index];
            String type = checkedEvents.get("type")[index];

            Event event;

            //NEED SOME HELP!!! EAGER BETTER SOLUTION
            switch (type) {
                case "Concert": {
                    event = new Concert(name, cost, description, tag);
                    break;
                }

                case "MasterClass": {
                    event = new MasterClass(name, cost, description, tag);
                    break;
                }

                case "Lecture": {
                    event = new Lecture(name, cost, description, tag);
                    break;
                }

                default: {
                    throw new IllegalStateException();
                }
            }

            User user = (User) request.getSession().getAttribute("user");

            Preference preference = new Preference(event, RATE);

            if (!user.getPreferences().contains(preference)) {
                user.getPreferences().add(preference);
                putPreferenceInDB(preference, user);
            }

            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("preferences", user.getPreferences());
        }
        getServletContext().getRequestDispatcher("/prefers.jsp").forward(request, response);
    }

    private void putPreferenceInDB(Preference preference, User user) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kiev_demo_db", "root", "1234")) {
            if (connection != null) {
                Statement statement = connection.createStatement();

                statement.executeUpdate("INSERT INTO kiev_demo_db.users (login, password, event_name) VALUES ('"
                        + user.getLogin() + "', '" + user.getPassword() + "', '" + preference.getEvent().getName() + "');");

                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}