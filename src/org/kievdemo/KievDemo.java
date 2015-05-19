package org.kievdemo;

import java.util.Date;

/**
 * Created by Ann on 18.05.2015.
 */
public class KievDemo {
    public static void main(String[] args) {
        OutDoor park = new OutDoor("EventName", new Place("NamePlace", new Location(33, 44, new Address("NameStreet", (short) 2))));
        park.getInfo();
    }
}
