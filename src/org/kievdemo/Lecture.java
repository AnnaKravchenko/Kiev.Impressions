package org.kievdemo;

import java.util.GregorianCalendar;
import java.util.List;

public class Lecture extends Event implements Repeatable<Lecture> {
    private Host host;

    //todo remove in lab 4
    public Lecture(String name, double cost, String description, String tag) {
        super(name, cost, description, tag);
        host = new Host();
    }

    public Lecture(String name, Place place, double cost, String description, GregorianCalendar time, String tag, Host host) {
        super(name, place, cost, description, time, tag);
        this.host = host;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "host=" + host +
                "} " + super.toString();
    }

    @Override
    public List<Lecture> getRepeats() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lecture)) return false;
        if (!super.equals(o)) return false;

        Lecture lecture = (Lecture) o;

        return !(host != null ? !host.equals(lecture.host) : lecture.host != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (host != null ? host.hashCode() : 0);
        return result;
    }
}
