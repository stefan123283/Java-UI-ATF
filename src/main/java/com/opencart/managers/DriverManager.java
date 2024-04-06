package com.opencart.managers;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    private static String webDriverType = ConfigReaderManager.getProperty("browserType");
    private static DriverManager instance;
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(DriverManager.class);

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                logger.log(Level.INFO, "The Chrome driver was initiated");
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                logger.log(Level.INFO, "The Firefox driver was initiated");
                break;
            case "EDGE":
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--incognito");
                driver = new EdgeDriver(options);
                logger.log(Level.INFO, "The Edge driver was initiated");
                break;
            case "SAFARI":
                driver = new SafariDriver();
                logger.log(Level.INFO, "The Safari driver was initiated");
            default:
                logger.log(Level.INFO, "There is not defined such a driver: " + webDriverType);
        }

        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(ConfigReaderManager.getProperty("pageLoadValue")), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReaderManager.getProperty("implicitWaitValue")), TimeUnit.SECONDS);
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            getInstance();
        }
        return driver;
    }

    public void quitTheDriver() {
        driver.quit();
        driver = null;
        instance = null;
    }

}