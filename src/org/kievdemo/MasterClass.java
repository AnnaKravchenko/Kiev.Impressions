package org.kievdemo;

import java.util.GregorianCalendar;
import java.util.List;

public class MasterClass extends Event implements Repeatable<MasterClass> {
    private Host host;

    //todo remove in lab 4
    public MasterClass(String name, double cost, String description, String tag) {
        super(name, cost, description, tag);
        host = new Host();
    }

    public MasterClass(String name, Place place, double cost, String description, GregorianCalendar time, String tag, Host host) {
        super(name, place, cost, description, time, tag);
        this.host = host;
    }

    @Override
    public String toString() {
        return "MasterClass{" +
                "host=" + host +
                "} " + super.toString();
    }

    @Override
    public List<MasterClass> getRepeats() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MasterClass)) return false;
        if (!super.equals(o)) return false;

        MasterClass that = (MasterClass) o;

        return !(host != null ? !host.equals(that.host) : that.host != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (host != null ? host.hashCode() : 0);
        return result;
    }
}
