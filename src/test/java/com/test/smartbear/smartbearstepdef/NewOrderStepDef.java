package com.test.smartbear.smartbearstepdef;

import com.test.smartbear.pages.LoginPage;
import com.test.smartbear.pages.MainPage;
import com.test.smartbear.pages.OrderPage;
import com.test.smartbear.pages.ViewOrderPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class NewOrderStepDef {
    WebDriver driver=DriverHelper.getDriver();
    LoginPage loginPage=new LoginPage(driver);
    MainPage mainPage=new MainPage(driver);
    OrderPage orderPage=new OrderPage(driver);
    ViewOrderPage viewOrderPage=new ViewOrderPage(driver);


    @Given("User types {string} and {string}")
    public void user_types_and(String username, String password) {
        loginPage.login(ConfigReader.readProperty("QA_smartbear_username"),
                ConfigReader.readProperty("QA_smartbear_password"));
    }
    @When("User clicks order button and picks product {string} and enters {string}")
    public void user_clicks_order_button_and_picks_product_and_enters(String product, String quantity) {
    mainPage.addOrder();
    orderPage.createAnOrder(product,quantity);

    }
    @Then("User types {string} , {string} , {string} , {string} {string} for address info")
    public void use_types_for_address_info(String customerName, String street, String city, String state, String zipCode) {
    orderPage.enterCustomerInfo(customerName, street, city,state,zipCode);
    }
    @Then("User clicks on {string} and enters {string} and {string}")
    public void user_clicks_on_and_enters_and(String card,String cardNumber, String expDate) throws InterruptedException {
    orderPage.paymentInfo(card,cardNumber, expDate);
    }
    @Then("User click process button and validates {string} and clicks view all orders")
    public void user_click_process_button_and_validates_and_clicks_view_all_orders(String expectedMessage) throws InterruptedException {
    orderPage.setProcessButton(expectedMessage);
    }
    @Then("User validates all info {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void user_validates_all_info(String customerName, String product, String quantity, String date, String city, String street, String state, String zipcode, String cardType, String cardNumber, String expirationDate) {
    viewOrderPage.validateTheAddedInfo(customerName,product, quantity,date, street, city, state, zipcode, cardType,cardNumber, expirationDate);
    }

}
