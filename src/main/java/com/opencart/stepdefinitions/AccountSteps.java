package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class AccountSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();

    @Then("The URL contains success keyword")
    public void theURLContainsSuccessKeyword() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("success"), "The registration was successful");
    }
}
