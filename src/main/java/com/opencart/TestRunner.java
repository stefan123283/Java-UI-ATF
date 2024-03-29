package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) {
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        String currentWindowName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://demo-opencart.ru/");
        System.out.println("The current URL is " + driver.getCurrentUrl());
        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
        System.out.println("The current URL is " + driver.getCurrentUrl());
        String firstName = FakeDataManager.generateRandomFirstname();
        String lastName = FakeDataManager.generateRandomLastname();
        String email = FakeDataManager.generateRandomEmail();
        String phoneNumber = FakeDataManager.generateRandomPhoneNumber();
        String password = FakeDataManager.generateRandomPassword();
        System.out.println("Firstname: " + firstName);
        System.out.println("Lastname: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Phone number: " + phoneNumber);
        System.out.println("Password: " + password);
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillInTheRegisterForm(firstName, lastName, email, phoneNumber, password);
        System.out.println("The current URL is " + driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(currentWindowName);
        driver.quit();
    }
}