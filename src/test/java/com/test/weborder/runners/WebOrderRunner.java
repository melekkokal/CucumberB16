package com.test.weborder.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features/weborder",//feature file location
        glue = "com/test/weborder/stepdef",
        dryRun = false,
        tags="@smoke or @apiregression",
        plugin={"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTest.txt"}
)
public class WebOrderRunner {

}
