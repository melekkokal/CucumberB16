package com.test.weborder.stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.sql.Driver;

public class Hook {
    WebDriver driver= DriverHelper.getDriver();

    @Before //import from cucumber.io
    public void setup(){
        driver.get(ConfigReader.readProperty("QA_weborder_url"));
//        driver.get(ConfigReader.readProperty("QA_weborder_email"));
//        driver.get(ConfigReader.readProperty("QA_weborder_password"));
    }

    @After//import from cucumber.io
    public void tearDown(){
       // driver.quit();
    }
}
