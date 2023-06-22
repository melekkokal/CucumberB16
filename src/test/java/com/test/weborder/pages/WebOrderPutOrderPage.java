package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

    @FindBy(xpath = "//div[@class='col']//p[1]")
    WebElement description;



    public void typeNoteAndInvites(String note, String emails, String emails1)
            throws InterruptedException {
        checkbox.click();
        Thread.sleep(2000);
        next.click();
        inviteNoteArea.sendKeys(note);
        Thread.sleep(2000);
        inviteListArea.sendKeys(emails,",", emails1);
        delivery.click();
    }

    public String PickTheLocation() throws InterruptedException {
        Select select=new Select(myHouseAddress);
        return BrowserUtils.getText(select.getFirstSelectedOption());

    }
    public String validateAddress(){
        return BrowserUtils.getText(address);
    }

    public String header() throws InterruptedException {
        groupOrderButton.click();
        Thread.sleep(1000);
        return BrowserUtils.getText(header);
    }
    public String description(){
        return BrowserUtils.getText(description);
    }


}
