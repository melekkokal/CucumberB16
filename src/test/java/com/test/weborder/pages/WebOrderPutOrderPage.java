package com.test.weborder.pages;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserUtils;

public class WebOrderPutOrderPage {
    public WebOrderPutOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='custom-control custom-checkbox']")
    WebElement checkbox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement next;

    @FindBy(xpath = "//textarea[@id='InviteNote']")
    WebElement inviteNoteArea;

    @FindBy(xpath = "//textarea[@id='InviteList']")
    WebElement inviteListArea;

    @FindBy(xpath = "//label[@class='btn btn-lg equalWidth btn-outline-primary active']")
    WebElement delivery;

    @FindBy(css = "#ConfirmAddressID")
    WebElement myHouseAddress;

    @FindBy(xpath = "//div[@id='addressPreview']")
    WebElement address;

    @FindBy(css="#createGroupOrder")
    WebElement groupOrderButton;

    @FindBy(tagName = "h1")
    WebElement header;

    @FindBy(xpath = "//p[contains(text(),'now pending')]")
    WebElement description;

    public void clickGroupOrderBox(){
        if(checkbox.isDisplayed()){
            checkbox.click();
        }
    }

    public void clickNextButton(){
        next.click();
    }


    public void typeNoteAndInvites(String note, String emails, String emails1) {
        inviteNoteArea.sendKeys(note);
        inviteListArea.sendKeys(emails,",", emails1);
        delivery.click();
    }

    public void chooseLocation(String myHouseAddress, String expectedAddress) {
        BrowserUtils.selectBy(this.myHouseAddress, myHouseAddress, "text"); //choose myhouse
        Assert.assertTrue(BrowserUtils.getText(address).contains(expectedAddress)); //validate it here
    }
    public void clickCreateGroupOrderButton() throws InterruptedException {
        groupOrderButton.click();
        Thread.sleep(2000);
    }
    public void validateHeaderAndDescription(String expectedHeader, String expectedDescription) {
       Assert.assertEquals(expectedHeader, BrowserUtils.getText(header));
       Assert.assertTrue(expectedDescription, BrowserUtils.getText(description).contains(expectedDescription));
    }


}
