package org.kievdemo;

/**
 * Created by Ann on 14.04.2015.
 */
public abstract class Event {
    private String name;
    private Place place;
    private double cost;
    private String descrption;
    private String tag;


    public abstract Occurrence getOccurrence();
}
