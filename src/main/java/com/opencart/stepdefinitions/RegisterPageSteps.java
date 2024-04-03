package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("Register Page is populated with valid random data")
    public void registerPageIsPopulatedWithValidRandomData() {
        registerPage.fillInTheRegisterForm(FakeDataManager.generateRandomFirstname(), FakeDataManager.generateRandomLastname(), FakeDataManager.generateRandomEmail(), FakeDataManager.generateRandomPhoneNumber(), FakeDataManager.generateRandomPassword());
    }

    @When("Register Page is populated with the following data:")
    public void registerPageIsPopulatedWithTheFollowingData(Map<String, String> userDetailsMap) {
        String firstName = userDetailsMap.get("firstName");
        String lastName = userDetailsMap.get("lastName");
        String email = userDetailsMap.get("email");
        ;
        String phoneNumber = userDetailsMap.get("phoneNumber");
        ;
        String password = userDetailsMap.get("password");
        ;

        if (firstName != null && firstName.equals("RANDOM")) {
            firstName = FakeDataManager.generateRandomFirstname();
        }

        if (lastName != null && lastName.equals("RANDOM")) {
            lastName = FakeDataManager.generateRandomLastname();
        }

        if (email != null && email.equals("RANDOM")) {
            email = FakeDataManager.generateRandomEmail();
        }

        if (phoneNumber != null && phoneNumber.equals("RANDOM")) {
            phoneNumber = FakeDataManager.generateRandomPhoneNumber();
        }

        if (password != null && password.equals("RANDOM")) {
            password = FakeDataManager.generateRandomPassword();
        }

        registerPage.fillInTheRegisterForm(firstName, lastName, email, phoneNumber, password);

    }
}