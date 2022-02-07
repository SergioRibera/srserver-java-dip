package com.sergioribera.rs;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test
    public void propertiesTest() {
        PProvider propertiesProvider = new PProvider();

        assertTrue(propertiesProvider.getProperty("ENVIROMENT", "prod") != null);
        assertTrue(propertiesProvider.getProperty("TEST", "no hay") == "no hay");
    }
}
