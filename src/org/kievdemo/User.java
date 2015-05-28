package org.kievdemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;

public class User {
    private Collection<Preference> preferences;

    public User(Collection<Preference> preferences) {
        this.preferences = preferences;
    }

    public Collection<Preference> getPreferencesByDate(GregorianCalendar date) throws NoEventForThisDayFoundExeption {
        ArrayList<Preference> filterForPrefernce = new ArrayList<>(); //name of list

        for (Preference preference : preferences) {
            if (preference.getEvent().getTime().equals(date)) { //Another date?
                filterForPrefernce.add(preference);
            }
        }

        if (!filterForPrefernce.isEmpty()) {
            return filterForPrefernce;
        } else {
            throw new NoEventForThisDayFoundExeption("Sorry! No events planned for that day!");
        }
    }
}
