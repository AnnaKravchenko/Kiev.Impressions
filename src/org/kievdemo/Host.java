package org.kievdemo;

public class Host {   //Genius. Indeed. And a few self-critical
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Host)) return false;

        Host host = (Host) o;

        return !(name != null ? !name.equals(host.name) : host.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
