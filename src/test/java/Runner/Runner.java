package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty","html:target/cucumberHTMLreport",
        "json:target/cucumber.json"},
        features="src/test/resources/DBFeatures",
        glue = "StepDefs",
        tags=  "@uidb",
        dryRun=true
)

public class Runner {
}
