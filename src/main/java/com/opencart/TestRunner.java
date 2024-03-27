package com.opencart;

import com.opencart.managers.DriverManager;
import org.openqa.selenium.WebDriver;

public class TestRunner {
    public static void main(String[] args) {
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        driver.get("https://www.example.com/");
        driver.close();
        driver.quit();
    }
}