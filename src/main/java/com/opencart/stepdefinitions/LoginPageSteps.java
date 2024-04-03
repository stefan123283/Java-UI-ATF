package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.LoginPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class LoginPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @When("The Login Page is populated with the following data:")
    public void theLoginPageIsPopulatedWithTheFollowingData(List<String> userDetailsList) {
        loginPage.fillInTheLoginForm(userDetailsList.get(0), userDetailsList.get(1));

    }
}