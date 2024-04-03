package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class GenericSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Given("The {string} link is accessed")
    public void theLinkIsAccessed(String webAddress){
        driver.get(webAddress);
    }

    @Then("The URL contains {string} keyword")
    public void theUrlContainsKeyword(String keyword){
        Assertions.assertTrue(driver.getCurrentUrl().contains(keyword));
    }

    @Then("The URL does not contain {string} keyword")
    public void theUrlDoesNotContainKeyword(String keyword){
        Assertions.assertFalse(driver.getCurrentUrl().contains(keyword));
    }
}