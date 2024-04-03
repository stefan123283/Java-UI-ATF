package com.opencart.stepdefinitions;

import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class HomePageSteps {
    WebDriver driver = DriverManager.getInstance().getDriver();
    HomePage homePage = new HomePage(driver);

    @Given("Home Page is accessed")
    public void homePageIsAccessed() {
        driver.get("https://demo-opencart.ru/");
    }

    @And("The register button from Home Page is clicked")
    public void theRegisterButtonFromHomePageIsClicked() {
        homePage.navigateToRegisterPage();
    }

    @And("The Login Page is accessed")
    public void theLoginPageIsAccessed(){
        homePage.navigateToLoginPage();
    }


}