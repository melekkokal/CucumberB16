package com.test.Google.stepdefinitions;

import com.test.Google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepDefinition {
    WebDriver driver= DriverHelper.getDriver();
    GoogleMainPage mainPage=new GoogleMainPage(driver);

    @Given("User navigates to Google")
    public void user_navigates_to_google() {
        driver.get("https://www.google.com/");
    }
    @When("User searches for CodeFish")
    public void user_searches_for_code_fish() {
        mainPage.searchItem("CodeFish");
    }
    @Then("User validates first page returns more than ten link")
    public void user_validates_first_page_returns_more_than_ten_link() {
        Assert.assertTrue(mainPage.linkCount(10));
    }
    @When("User searches for Kyrgyz Food in USA")
    public void user_searches_for_kyrgyz_food_in_usa() {
       mainPage.searchItem("Kyrgyz Food in USA");
    }
    @Then("User validates the result is less than 300000000")
    public void user_validates_the_result_is_less_than() {
        Assert.assertTrue(mainPage.resultsfromsearch(300000000));
    }

    @When("User searches for Turkish baklava")
    public void user_searches_for_turkish_baklava() {
        mainPage.searchItem("Turkish baklava");
    }
    @Then("User validates the result was loaded in less than one second.")
    public void user_valiates_the_result_was_loaded_in_less_than_second() {

        Assert.assertTrue(mainPage.pageLoaded(1));
    }

}


