package org.kievdemo;


import java.util.Date;

/**
 * Created by Ann on 14.04.2015.
 */
public abstract class Event {
    private String name;
    private Place place;
    private double cost;
    private String descrption;
    private Date time;
    private String tag;

    public Event() {
        super();
    }

    public Event(String name, Place place, double cost, String descrption, Date time, String tag) {
        this.name = name;
        this.place = place;
        this.cost = cost;
        this.descrption = descrption;
        this.time = time;
        this.tag = tag;
    }

//    public String getName() {
//        return name;
//    }
//
//    public Place getAdress() {
//        return place;
//    }

    public abstract void getInfo();

    public abstract Occurrence getOccurrence();
}
