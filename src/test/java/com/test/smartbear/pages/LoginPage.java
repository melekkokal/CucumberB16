package com.test.smartbear.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="#ctl00_MainContent_username")
    WebElement username;

    @FindBy(css="#ctl00_MainContent_password")
    WebElement password;

    public void login(String userName, String Password){
        username.sendKeys(userName);
        password.sendKeys(Password, Keys.ENTER);
    }
}
