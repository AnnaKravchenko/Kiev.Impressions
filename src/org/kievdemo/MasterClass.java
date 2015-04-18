package org.kievdemo;

import java.util.List;

/**
 * Created by Ann on 16.04.2015.
 */
public class MasterClass extends Event implements Repeatable {
    private List<Occurrence> occurrences;

    @Override
    public List<Occurrence> getOccurrences() {
        return occurrences;
    }

    @Override
    public Occurrence getOccurrence() {
        return occurrences.get(0);
    }
}
