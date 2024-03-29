package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Page {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameInput;
    @FindBy(id = "input-lastname")
    private WebElement lastNameInput;
    @FindBy(id = "input-email")
    private WebElement emailInput;
    @FindBy(id = "input-telephone")
    private WebElement phoneNumberInput;
    @FindBy(id = "input-password")
    private WebElement passwordInput;
    @FindBy(id = "input-confirm")
    private WebElement confirmPasswordInput;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[1]")
    private WebElement policyToggle;
    @FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
    private WebElement continueButton;

    public void fillInTheRegisterForm(String firstName, String lastName, String email, String phoneNumber, String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        phoneNumberInput.sendKeys(phoneNumber);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        policyToggle.click();
        continueButton.click();
    }
}