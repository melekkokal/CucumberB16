package com.test.etsy.stepdef;

import com.test.etsy.pages.EtsyMainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepDef {
    WebDriver driver= DriverHelper.getDriver();
    EtsyMainPage mainPage=new EtsyMainPage(driver);

    @When("User searches for {string} on Etsy")
    public void user_searches_for_on_etsy(String item) {
    mainPage.search(item);
    }
    @Then("User validates the title {string} on Etsy")
    public void user_validates_the_title_on_etsy(String expectedTitle) {
        Assert.assertEquals(expectedTitle, driver.getTitle().trim());
    }
}
