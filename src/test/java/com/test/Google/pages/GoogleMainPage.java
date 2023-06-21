package com.test.Google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class GoogleMainPage {
    public GoogleMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@name='q']")
    WebElement searchBar;

    @FindBy(xpath = "//a//h3")
    List<WebElement> allLinks;

    @FindBy(xpath = "//div[@id='result-stats']")
    WebElement result;

    @FindBy(tagName = "nobr")
    WebElement baklava;

    public void searchItem(String item){
        searchBar.sendKeys(item, Keys.ENTER);
    }

    public boolean linkCount(int expectedNumber){
        return allLinks.size()>expectedNumber;
    }

    public boolean resultsfromsearch(int expectedResult){
        String [] results= BrowserUtils.getText(this.result).split(" "); //About 129,000,000 results
        return Integer.parseInt(results[1].replace(",", ""))<expectedResult;
    }

    public boolean pageLoaded(double expectedTime){
        String [] time=BrowserUtils.getText(baklava).split(" "); //About 12,400,000 results (0.49 seconds)
        return Double.parseDouble(time[0].replace("(", "").replace(",", ""))<expectedTime;
    }


}
