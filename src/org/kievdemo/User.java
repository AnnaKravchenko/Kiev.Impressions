package org.kievdemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class User {
    private String login;
    private String password;

    private Collection<Preference> preferences;

    public User() {
        preferences = new LinkedList<>();
    }

    public User(Collection<Preference> preferences) {
        this.preferences = preferences;
    }

    public User(String login, String password) {
        this();
        this.login = login;
        this.password = password;
    }

    public Collection<Preference> getPreferences() {
        return preferences;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return !(password != null ? !password.equals(user.password) : user.password != null);

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder preferencesSting = new StringBuilder();

        for (Preference p: preferences) {
            preferencesSting.append(p.toString());
        }

        return "User{" +
                "preferences=" + preferencesSting +
                '}';
    }
}
