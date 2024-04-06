package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);
    private static final Logger logger = LogManager.getLogger(RegisterPageSteps.class);

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

        logger.log(Level.INFO, "Random generated data for register flow:");
        logger.log(Level.INFO, "First name: " + firstName);
        logger.log(Level.INFO, "Last name: " + lastName);
        logger.log(Level.INFO, "Email: " + email);
        logger.log(Level.INFO, "Phone number: " + phoneNumber);
        logger.log(Level.INFO, "Password: " + password);

        registerPage.fillInTheRegisterForm(firstName, lastName, email, phoneNumber, password);

    }
}