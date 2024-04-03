package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    public Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/a/i")
    protected WebElement myAccountIcon;
    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
    protected WebElement registerBtn;

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
    protected WebElement loginBtn;

}