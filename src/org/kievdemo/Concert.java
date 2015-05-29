package org.kievdemo;

import java.util.GregorianCalendar;
import java.util.List;

public class Concert extends Event implements Repeatable<Concert> {
    private Host host;

    //todo remove in lab 4
    public Concert(String name, double cost, String description, String tag) {
        super(name, cost, description, tag);
        host = new Host();
    }

    public Concert(String name, Place place, double cost, String description, GregorianCalendar time, String tag, Host host) {
        super(name, place, cost, description, time, tag);
        this.host = host;
    }

    @Override
    public String toString() {
        return "Concert{" +
                "host=" + host +
                "} " + super.toString();
    }

    @Override
    public List<Concert> getRepeats() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Concert)) return false;
        if (!super.equals(o)) return false;

        Concert concert = (Concert) o;

        return !(host != null ? !host.equals(concert.host) : concert.host != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (host != null ? host.hashCode() : 0);
        return result;
    }
}
