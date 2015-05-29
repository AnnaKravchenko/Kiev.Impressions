package org.kievdemo;


import java.util.GregorianCalendar;

public abstract class Event {
    private String name;
    private Place place;
    private double cost;
    private String description;
    private GregorianCalendar time;
    private String tag;

    //todo remove in lab 4
    public Event() {
        place = new Place();
        //Magic - the date when it worked!
        time = new GregorianCalendar(2015, 4, 29);
    }

    //todo remove in lab 4

    public Event(String name, double cost, String description, String tag) {
        this();
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.tag = tag;
    }

    public Event(String name, Place place, double cost, String description, GregorianCalendar time, String tag) {// еще раз
        this.name = name;
        this.place = place;
        this.cost = cost;
        this.description = description;
        this.time = time;
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public GregorianCalendar getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
//                ", place=" + place +
                ", cost=" + cost +
                ", description='" + description + '\'' +
//                ", time=" + time +
                ", tag='" + tag + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (place != null ? !place.equals(event.place) : event.place != null) return false;
        return !(time != null ? !time.equals(event.time) : event.time != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }
}