package org.kievdemo;


import java.util.GregorianCalendar;

public abstract class Event {
    private String name;
    private Place place;
    private double cost;
    private String description;
    private GregorianCalendar time;
    private String tag;

    public Event(String name, Place place, double cost, String description, GregorianCalendar time, String tag) {
        this.name = name;
        this.place = place;
        this.cost = cost;
        this.description = description;
        this.time = time;
        this.tag = tag;
    }

    public GregorianCalendar getTime() {
        return time;
    }

    public String getTag() {
        return tag;
    }

    public abstract void getInfo();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event)) return false;

        Event event = (Event) o;

        if (Double.compare(event.cost, cost) != 0) return false;
        if (name != null ? !name.equals(event.name) : event.name != null) return false;
        if (place != null ? !place.equals(event.place) : event.place != null) return false;
        if (description != null ? !description.equals(event.description) : event.description != null) return false;
        if (time != null ? !time.equals(event.time) : event.time != null) return false;
        return !(tag != null ? !tag.equals(event.tag) : event.tag != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + (place != null ? place.hashCode() : 0);
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }
}