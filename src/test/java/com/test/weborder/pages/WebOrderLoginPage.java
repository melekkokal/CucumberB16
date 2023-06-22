package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WebOrderLoginPage {

    public WebOrderLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='Email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='Password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signInButton;

    @FindBy(css = ".alert-danger")
    WebElement message;

    public void signin(String Useremail, String UserPassword){
        email.clear();
        email.sendKeys(Useremail);
        password.clear();
        password.sendKeys(UserPassword);
        signInButton.click();
    }

    public String errorMessage(){
        return BrowserUtils.getText(message);
    }

}
