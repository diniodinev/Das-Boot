package com.boot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.boot.controller.HomeController;

public class AppTest {
    
    @Test
    public void testApp() {
        HomeController home = new HomeController();
        String message = home.home();
        assertEquals("This is Spring boot application.", message);
    }
}
