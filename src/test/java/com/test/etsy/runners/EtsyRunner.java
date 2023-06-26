package com.test.etsy.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features/Etsy/EtsySearch.feature",//feature file location
        glue = "com/test/etsy/stepdef",
        dryRun = false,
        tags="@apiregression", //if it is grey there is no regression type.
        plugin={"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTest.txt"}
)
public class EtsyRunner {

}
