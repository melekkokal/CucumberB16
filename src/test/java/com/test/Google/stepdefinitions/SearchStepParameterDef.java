package com.test.Google.stepdefinitions;

import com.test.Google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepParameterDef {
    WebDriver driver= DriverHelper.getDriver();
    GoogleMainPage mainPage=new GoogleMainPage(driver);
    @Given("User navigates to {string}")
    public void user_navigates_to(String website) {
      driver.get(website);
    }
    @When("User searches for {string}")
    public void user_searches_for(String searchItem) {
    mainPage.searchItem(searchItem);
    }
    @Then("User validates first page returns more than {int} link")
    public void user_validates_first_page_returns_more_than_link(Integer expectedLinkNumber) throws InterruptedException {
        Assert.assertTrue(mainPage.linkCount(expectedLinkNumber));
    }


    @Then("User validates the result is less than {int}")
    public void user_validates_the_result_is_less_than(Integer givenAmount) {
        Assert.assertTrue(mainPage.resultsfromsearch(givenAmount));
    }

    @Then("User validates the result was loaded in less than {double} second.")
    public void user_validates_the_result_was_loaded_in_less_than_second(Double expectedTime) {
        Assert.assertTrue(mainPage.pageLoaded(expectedTime));
    }
}
