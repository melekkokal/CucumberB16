package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

import java.util.List;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement product;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;

    @FindBy(css="#ctl00_MainContent_fmwOrder_txtName")
    WebElement customerName;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zip;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList")
    List<WebElement> cardType;

    @FindBy(css="#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardnumber;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expirationDate;

    @FindBy(css = ".btn_light")
    WebElement processButton;

    @FindBy(xpath = "//div//strong")
    WebElement processedmessage;

    @FindBy(xpath = "//ul//li[.='View all orders']")
    WebElement allOrdersButton;

    public void createAnOrder(String item, String quantty){
        Select select=new Select(product);
        select.selectByVisibleText(item);
        quantity.sendKeys(quantty);
    }

    public void enterCustomerInfo(String name, String st, String cty, String stte, String zipcode){
        customerName.sendKeys(name);
        street.sendKeys(st);
        city.sendKeys(cty);
        state.sendKeys(stte);
        zip.sendKeys(zipcode);
    }

    public void paymentInfo(String card, String cardNmber, String exprDate) throws InterruptedException {
        for (int i = 0; i<cardType.size();i++){
            if (BrowserUtils.getText(cardType.get(i)).contains(card)){
                cardType.get(i).click();
            }
        }
        Thread.sleep(2000);
    cardnumber.sendKeys(cardNmber);
    expirationDate.sendKeys(exprDate);
    }

    public void setProcessButton(String expectedTitle) throws InterruptedException {
        processButton.click();
        Thread.sleep(2000);
        Assert.assertEquals(expectedTitle,processedmessage.getText().trim());
        allOrdersButton.click();
    }


}
