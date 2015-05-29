package org.kievdemo;

import java.util.GregorianCalendar;

public class OutDoor extends Event {
    private String dress;

    public OutDoor(String name, double cost, String description, String tag) {
        super(name, cost, description, tag);
    }

    public OutDoor(String name, Place place, double cost, String description, GregorianCalendar time, String tag, String dress) {
        super(name, place, cost, description, time, tag);
        this.dress = dress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OutDoor)) return false;
        if (!super.equals(o)) return false;

        OutDoor outDoor = (OutDoor) o;

        return !(dress != null ? !dress.equals(outDoor.dress) : outDoor.dress != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (dress != null ? dress.hashCode() : 0);
        return result;
    }
}
