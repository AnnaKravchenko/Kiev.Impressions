package org.kievdemo;

import java.util.GregorianCalendar;
import java.util.List;

public class MasterClass extends Event implements Repeatable<MasterClass> {
    private Host host;

    public MasterClass(String name, Place place, double cost, String description, GregorianCalendar time, String tag, Host host) {
        super(name, place, cost, description, time, tag);
        this.host = host;
    }

    @Override
    public void getInfo() {

    }

    @Override
    public List<MasterClass> getReapeats() {
        return null;
    }
}
