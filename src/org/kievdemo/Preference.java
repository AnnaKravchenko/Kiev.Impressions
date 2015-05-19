package org.kievdemo;

public class Preference {
    private final Event event;
    private int rate;

    public Preference(Event event, int rate) {
        this.event = event;
        this.rate = rate;
    }

    public Event getEvent() {
        return event;
    }

    public String sayHello() {
        return "Hello!";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Preference)) return false;

        Preference that = (Preference) o;

        if (rate != that.rate) return false;
        return !(event != null ? !event.equals(that.event) : that.event != null);

    }

    @Override
    public int hashCode() {
        int result = event != null ? event.hashCode() : 0;
        result = 31 * result + rate;
        return result;
    }
}
