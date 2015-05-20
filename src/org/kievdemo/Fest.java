package org.kievdemo;

import java.util.GregorianCalendar;

public class Fest extends Event {
    private GregorianCalendar lastDay;

    public Fest(String name, Place place, double cost, String description, GregorianCalendar time, String tag, GregorianCalendar lastDay) {
        super(name, place, cost, description, time, tag);

        if (this.getTime().compareTo(lastDay) < 0) {
            this.lastDay = lastDay;
        } else {
            throw new IllegalArgumentException("This Fest ends earlier than it begins!");
        }
    }

    @Override
    public void getInfo() {

    }
}
