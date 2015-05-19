package org.kievdemo;

import java.util.GregorianCalendar;

public class OutDoor extends Event {
    private String dress;

    public OutDoor(String name, Place place, double cost, String description, GregorianCalendar time, String tag, String dress) {
        super(name, place, cost, description, time, tag);
        this.dress = dress;
    }

    @Override
    public void getInfo() {

    }
}
