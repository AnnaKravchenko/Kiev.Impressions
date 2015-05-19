package org.kievdemo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Ann on 10.05.2015.
 */
public class PreferenceTest {
    private Preference preference;

    @Before
    public void setUp() throws Exception {
        this.preference = new Preference();

    }

    @Test
    public void testSayHello() throws Exception {
        assertEquals("Hello!", preference.sayHello());
    }
}