package com.opencart.managers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitManager {
    static WebDriver driver = DriverManager.getInstance().getDriver();
    private static final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigReaderManager.getProperty("explicitWaitValue"))));
    private static final Logger logger = LogManager.getLogger(ExplicitWaitManager.class);

    public static void waitTillTheElementIsVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
        logger.log(Level.INFO, "The element - " + webElement.getAccessibleName() + " is visible");
    }

    public static void waitTillTheElementIsClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        logger.log(Level.INFO, "The element - " + webElement.getAccessibleName() + " is clickable");
    }
}