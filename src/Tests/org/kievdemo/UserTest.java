package org.kievdemo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class UserTest {
    private User user;
    private ArrayList<Preference> preferences;

    @Before
    public void setUp() {
        preferences = new ArrayList<>();

        preferences.add(new Preference(new Concert("JazzCon",
                new Place("Jazz Hole",
                        new Location(33.0, 44.0,
                                new Address("Jazz Valley", (short) 2)),
                        new LinkedList<>()),
                100.0,
                "Best Jazz party",
                new GregorianCalendar(2015, 4, 24),
                "jazz",
                new Host()), 5));

        preferences.add(new Preference(new MasterClass("Drawing for braindead",
                new Place("Jazz Hole",
                        new Location(33.0, 44.0,
                                new Address("Jazz Valley", (short) 2)),
                        new LinkedList<>()),
                500.0,
                "Relax",
                new GregorianCalendar(2015, 7, 24),
                "drawing",
                new Host()), 10));

        preferences.add(new Preference(new Lecture("OOP",
                new Place("KPI",
                        new Location(33.0, 44.0,
                                new Address("KPI", (short) 2)),
                        new LinkedList<>()),
                100.0,
                "BEST LECTURE EVA",
                new GregorianCalendar(2015, 7, 24),
                "oop",
                new Host()), 100));

        user = new User(preferences);
    }

    @Test
    public void testGetPreferencesByDate() throws MyException {
        assertTrue(user.getPreferencesByDate(new GregorianCalendar(2015, 7, 24)).contains(preferences.get(1)));
        assertTrue(user.getPreferencesByDate(new GregorianCalendar(2015, 7, 24)).contains(preferences.get(2)));

        assertFalse(user.getPreferencesByDate(new GregorianCalendar(2015, 7, 24)).contains(preferences.get(0)));
    }

    @Test(expected = MyException.class)
    public void testGetPreferencesByDateException() throws MyException {
        user.getPreferencesByDate(new GregorianCalendar(1996, 9, 12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPreferenceException() {
        new Preference(new Fest("OOP",
                new Place("KPI",
                        new Location(33.0, 44.0,
                                new Address("KPI", (short) 2)),
                        new LinkedList<>()),
                100.0,
                "BEST LECTURE EVA",
                new GregorianCalendar(2025, 7, 4),
                "oop",
                new GregorianCalendar(2015, 7, 21)), 100);
    }
}