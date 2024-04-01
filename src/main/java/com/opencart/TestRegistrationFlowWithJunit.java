package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public class TestRegistrationFlowWithJunit {

    static WebDriver driver;
    HomePage homePage;
    RegisterPage registerPage;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("The test suite execution has started.");
    }

    @BeforeEach
    public void beforeEach() {
        driver = DriverManager.getInstance().getDriver();
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        driver.get("https://demo-opencart.ru/");
    }

    @Test
    @DisplayName("Successful registration with valid data")
    public void registrationWithValidData() {
        homePage.navigateToRegisterPage();
        String firstName = FakeDataManager.generateRandomFirstname();
        String lastName = FakeDataManager.generateRandomLastname();
        String email = FakeDataManager.generateRandomEmail();
        String phoneNumber = FakeDataManager.generateRandomPhoneNumber();
        String password = FakeDataManager.generateRandomPassword();
        registerPage.fillInTheRegisterForm(firstName,lastName,email,phoneNumber,password);
        Assertions.assertTrue(driver.getCurrentUrl().contains("success"), "The registration was successful");
    }

    @Test
    @DisplayName("Unsuccessful registration with invalid data")
    public void registrationWithInvalidData() {
        homePage.navigateToRegisterPage();
        String firstName = FakeDataManager.generateRandomFirstname();
        String lastName = FakeDataManager.generateRandomLastname();
        String email = FakeDataManager.generateRandomEmail();
        String phoneNumber = FakeDataManager.generateRandomPhoneNumber();
        registerPage.fillInTheRegisterForm(firstName,lastName,email,phoneNumber,"1");
        Assertions.assertFalse(driver.getCurrentUrl().contains("success"), "The registration was successful");
        System.out.println(driver.getCurrentUrl());
    }

    @AfterEach
    public void afterEach(){
        DriverManager.getInstance().quitTheDriver();
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("The test suite execution has ended.");
    }

}