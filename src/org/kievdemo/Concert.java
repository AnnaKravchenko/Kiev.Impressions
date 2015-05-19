package org.kievdemo;

import java.util.GregorianCalendar;
import java.util.List;

public class Concert extends Event implements Repeatable<Concert> {
    private Host host;

    public Concert(String name, Place place, double cost, String description, GregorianCalendar time, String tag, Host host) {
        super(name, place, cost, description, time, tag);
        this.host = host;
    }

    @Override
    public void getInfo() {

    }

    @Override
    public List<Concert> getReapeats() {
        return null;
    }
}
