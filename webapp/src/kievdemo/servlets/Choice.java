package kievdemo.servlets;

import org.kievdemo.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class Choice extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> checkedEvents = request.getParameterMap();

        final int RATE = 5;

        //this will actually connect to database and operate with it
        //now just a temp solution using sessions
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

                //Dummy constructor. Will be replaced.
                default: {
                    event = new Fest(name, cost, description, tag);
                }
            }

            User user = (User) request.getSession().getAttribute("user");

            Preference preference = new Preference(event, RATE);

            if (!user.getPreferences().contains(preference)) {
                user.getPreferences().add(preference);
            }

            System.out.println(user.getPreferences());

            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("preferences", user.getPreferences());
        }
        getServletContext().getRequestDispatcher("/prefers.jsp").forward(request, response);
    }
}
