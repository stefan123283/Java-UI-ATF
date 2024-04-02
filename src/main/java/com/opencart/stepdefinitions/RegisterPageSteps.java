package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("Register Page is populated with valid random data")
    public void registerPageIsPopulatedWithValidRandomData() {
        registerPage.fillInTheRegisterForm(FakeDataManager.generateRandomFirstname(), FakeDataManager.generateRandomLastname(), FakeDataManager.generateRandomEmail(), FakeDataManager.generateRandomPhoneNumber(), FakeDataManager.generateRandomPassword());
    }
}