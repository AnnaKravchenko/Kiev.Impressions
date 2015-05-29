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

    @Override
    public String toString() {
        return "Preference{" +
                "event=" + event +
                ", rate=" + rate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Preference)) return false;

        Preference that = (Preference) o;

        return !(event != null ? !event.equals(that.event) : that.event != null);

    }

    @Override
    public int hashCode() {
        return event != null ? event.hashCode() : 0;
    }
}
