package org.kievdemo;

/**
 * Created by Ann on 16.04.2015.
 */
public class Location {
    private double latitute;
    private double longtitule;

    private Address address;

    public Location(double latitute, double longtitule, Address address) {
        this.latitute = latitute;
        this.longtitule = longtitule;
        this.address = address;
    }
}
