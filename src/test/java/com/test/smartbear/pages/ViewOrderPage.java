package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class ViewOrderPage {

    public ViewOrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr[2]//td")
    List<WebElement> allInfo;

    public void validateTheAddedInfo(String customerName,String product, String quantity, String date, String street, String city, String state, String zipcode, String cardType,String cardNumber, String expirationDate){
        List<String> expectedInfo= Arrays.asList("",customerName,product,quantity,date, street, city, state, zipcode, cardType,cardNumber, expirationDate,"");
        for(int i=1; i< allInfo.size()-1; i++){
            if (BrowserUtils.getText(allInfo.get(i)).equals(expectedInfo.get(i))){
                Assert.assertEquals(expectedInfo.get(i),BrowserUtils.getText(allInfo.get(i)));
            }
        }
        }
    }



