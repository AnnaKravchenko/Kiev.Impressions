package org.kievdemo;

/**
 * Created by Ann on 16.04.2015.
 */
public class Concert extends Event {

    private Occurrence occurrence;

    public Concert() {
        this.occurrence = new Occurrence();
    }

    @Override
    public Occurrence getOccurrence() {
        return occurrence;
    }
}
