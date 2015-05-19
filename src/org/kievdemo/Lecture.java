package org.kievdemo;

import java.util.GregorianCalendar;
import java.util.List;

public class Lecture extends Event implements Repeatable<Lecture> {
    private Host host;

    public Lecture(String name, Place place, double cost, String description, GregorianCalendar time, String tag, Host host) {
        super(name, place, cost, description, time, tag);
        this.host = host;
    }

    @Override
    public void getInfo() {

    }

    @Override
    public List<Lecture> getReapeats() {
        return null;
    }
}
