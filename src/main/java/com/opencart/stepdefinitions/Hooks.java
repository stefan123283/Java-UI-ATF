package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class Hooks {

    private static int counter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("The test suite execution has started.");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("The execution of test " + counter++ + " has started");
    }

    @AfterEach
    public void afterEach() {
        DriverManager.getInstance().quitTheDriver();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("The test suite execution has ended.");
    }
}