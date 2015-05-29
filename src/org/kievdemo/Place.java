package org.kievdemo;

import java.util.Collection;
import java.util.LinkedList;

public class Place {
    private String name;
    private Location location;
    private Collection<String> comments;

    //todo remove in lab 4

    public Place() {
        location = new Location();
        comments = new LinkedList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;

        Place place = (Place) o;

        if (name != null ? !name.equals(place.name) : place.name != null) return false;
        if (location != null ? !location.equals(place.location) : place.location != null) return false;
        return !(comments != null ? !comments.equals(place.comments) : place.comments != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    public Place(String name, Location location, Collection<String> comments) {
        this.name = name;
        this.location = location;
        this.comments = comments;
    }
}