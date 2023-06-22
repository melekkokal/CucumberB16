package com.test.weborder.stepdef;

import com.test.weborder.pages.WebOrderLoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import utils.DriverHelper;
/*#1-Login successfully weborder page parameterize username and password in feature file

        #2 click the order box and next button
        #3 send invitees section to "I LOVE SELENIUM"
        #4 send inviteList "email@gmail.com" and "email2@gmail.com"
        #5 choose the delivery option "My House" and validate adress(contains) "3137 Laguna"
        #6 click group order button
        #7 Validate the header "View Group Order"(think about thread.sleep)
        #8 Validate the description contains(Your group order is now pending) from description*/

public class LoginStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderLoginPage loginPage=new WebOrderLoginPage(driver);

    @When("User enters  {string}, {string} and clicks sign in button")
    public void user_enters_and_clicks_sign_in_button(String email, String password) {
       loginPage.signin(email, password);
    }
    @Then("User validates {string}")
    public void user_validates(String expectedTitle) {
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @Then("User validates the message {string}")
    public void user_validates_the_message(String expectedMessage) {
        Assert.assertEquals(expectedMessage, loginPage.errorMessage());
    }


}
