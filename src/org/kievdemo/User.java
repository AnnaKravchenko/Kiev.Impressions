package org.kievdemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

public class User {
    private Collection<Preference> preferences;

    public User(Collection<Preference> preferences) {
        this.preferences = preferences;
    }

    public Collection<Preference> getPreferencesByDate(GregorianCalendar date) throws MyException {
        ArrayList<Preference> matches = new ArrayList<>();

        for (Preference p : preferences) {
            if (p.getEvent().getTime().equals(date)) {
                matches.add(p);
            }
        }

        if (!matches.isEmpty()) {
            return matches;
        } else {
            throw new MyException("No events planned for that day!");
        }
    }
}
