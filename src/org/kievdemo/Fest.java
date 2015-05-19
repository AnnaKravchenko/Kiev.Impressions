package org.kievdemo;

import java.util.Date;
import java.util.List;

public class Fest extends Event {
    private Date fromTo;

    public Fest(String name, Place place, double cost, String descrption, Date time, String tag, Date fromTo) {
        super(name, place, cost, descrption, time, tag);
        this.fromTo = fromTo;
    }

    @Override
    public void getInfo() {

    }

    @Override
    public Occurrence getOccurrence() {
        return null;
    }
}
