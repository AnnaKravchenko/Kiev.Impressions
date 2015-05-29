package org.kievdemo;

import java.util.GregorianCalendar;

public class Fest extends Event {
    private GregorianCalendar lastDay;

    //todo remove in lab 4
    public Fest(String name, double cost, String description, String tag) {
        super(name, cost, description, tag);
        lastDay = new GregorianCalendar();
    }

    public Fest(String name, Place place, double cost, String description, GregorianCalendar time, String tag, GregorianCalendar lastDay) {
        super(name, place, cost, description, time, tag);

        if (this.getTime().compareTo(lastDay) < 0) { //when I<II
            this.lastDay = lastDay;
        } else {
            throw new IllegalArgumentException("This Fest ends earlier than it begins!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fest)) return false;
        if (!super.equals(o)) return false;

        Fest fest = (Fest) o;

        return !(lastDay != null ? !lastDay.equals(fest.lastDay) : fest.lastDay != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (lastDay != null ? lastDay.hashCode() : 0);
        return result;
    }
}
