package com.test.weborder.stepdef;

import com.test.weborder.pages.WebOrderLoginPage;
import com.test.weborder.pages.WebOrderPutOrderPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class PutOrderStepDef {

    WebDriver driver= DriverHelper.getDriver();
    WebOrderLoginPage loginPage=new WebOrderLoginPage(driver);
    WebOrderPutOrderPage putOrderPage=new WebOrderPutOrderPage(driver);

    @Given("User enters username and password")
    public void user_enters_username_and_password() {
        loginPage.signin(ConfigReader.readProperty("QA_weborder_email"), ConfigReader.readProperty("QA_weborder_password"));
    }
    @Then("User clicks group order and next button")
    public void user_clicks_group_order_and_next_button() {
        putOrderPage.clickGroupOrderBox();
        putOrderPage.clickNextButton();
    }
    @Then("User sends {string} to invitees and add {string} and {string}")
    public void user_sends_to_invitees_and_add_and(String message, String email1, String email2) {
        putOrderPage.typeNoteAndInvites(message,email1,email2);
    }
    @And("User chooses the service method {string}, validates {string} and clicks create group order button")
    public void user_chooses_the_service_method_my_house_validates_and_clicks_create_group_order_button(String myhouse,String address) {
        putOrderPage.chooseLocation(myhouse, address);

    }
    @Then("User validates {string} and {string}")
    public void user_validates_and(String header, String expectedDescription) throws InterruptedException {
        putOrderPage.clickCreateGroupOrderButton();
        putOrderPage.validateHeaderAndDescription(header, expectedDescription);

    }
}


