package org.kievdemo;

public class Location {
    private double latitute;
    private double longtitule;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        if (Double.compare(location.latitute, latitute) != 0) return false;
        if (Double.compare(location.longtitule, longtitule) != 0) return false;
        return !(address != null ? !address.equals(location.address) : location.address != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(latitute);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longtitule);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    private Address address;

    public Location(double latitute, double longtitule, Address address) {
        this.latitute = latitute;
        this.longtitule = longtitule;
        this.address = address;
    }
}