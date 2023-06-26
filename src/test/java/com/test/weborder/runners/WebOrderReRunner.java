package com.test.weborder.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/uiFailedTest.txt",
        glue="com/test/weborder/stepdef",
        tags="@apiregression",
        plugin = {"pretty", "html:target/uiReport.html","rerun:target/uiFailedTest.txt"}
)
public class WebOrderReRunner {
}
