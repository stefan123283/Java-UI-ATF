package com.opencart;

import com.opencart.managers.DriverManager;
import com.opencart.managers.FakeDataManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) {
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        String currentWindowName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://demo-opencart.ru/");
        System.out.println("The current URL is " + driver.getCurrentUrl());
        WebElement myAccountIcon = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/i"));
        myAccountIcon.click();
        WebElement registerBtn = driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a"));
        registerBtn.click();
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
        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
        firstNameInput.sendKeys(firstName);
        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
        lastNameInput.sendKeys(lastName);
        WebElement emailInput = driver.findElement(By.id("input-email"));
        emailInput.sendKeys(email);
        WebElement phoneNumberInput = driver.findElement(By.id("input-telephone"));
        phoneNumberInput.sendKeys(phoneNumber);
        WebElement passwordInput = driver.findElement(By.id("input-password"));
        passwordInput.sendKeys(password);
        WebElement passwordInputConfirmation = driver.findElement(By.id("input-confirm"));
        passwordInputConfirmation.sendKeys(password);
        WebElement policyToggle = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
        policyToggle.click();
        WebElement continueBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        continueBtn.click();
        System.out.println("The current URL is " + driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(currentWindowName);
        driver.quit();
    }
}