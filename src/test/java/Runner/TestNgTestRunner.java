package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
                 features="src/test/resources/Product.feature",
                 glue ="StepDefinitions",
                 monochrome = true,
        plugin={"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestNgTestRunner extends AbstractTestNGCucumberTests {
}
