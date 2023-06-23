package com.test.weborder.stepdef;

import com.test.weborder.pages.WebOrderPutOrderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class PutOrderStepDef {

    WebDriver driver= DriverHelper.getDriver();
    WebOrderPutOrderPage putOrderPage=new WebOrderPutOrderPage(driver);


    @When("User clicks group order and next button and sends {string} to invitees and add {string} and {string}")
    public void user_sends_to_invitees_and_add(String note, String email1,String email2) throws InterruptedException {
        putOrderPage.typeNoteAndInvites(note,email1, email2);
    }
    @Then("User chooses the service method {string}, validates {string} and clicks create group order button")
    public void user_chooses_the_service_method_my_house_validates_and_clicks_create_group_order_button(String myhouse,String address) throws InterruptedException {
        Assert.assertTrue(putOrderPage.PickTheLocation().contains(myhouse));
        Assert.assertTrue(putOrderPage.validateAddress().contains(address));

    }
    @Then("User validates {string} and {string}")
    public void user_validates_and(String header, String expectedDescription) throws InterruptedException {
       Assert.assertEquals(header, putOrderPage.header());
       Assert.assertTrue(putOrderPage.description().contains(expectedDescription));
    }
}
