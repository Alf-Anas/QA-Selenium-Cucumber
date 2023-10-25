package dev.geoit.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/java/dev/geoit/cucumber/features/login.feature",
                "src/test/java/dev/geoit/cucumber/features/logout.feature",
                "src/test/java/dev/geoit/cucumber/features/product-cart.feature",
                "src/test/java/dev/geoit/cucumber/features/checkout-process.feature",
        },
        glue = "dev.geoit.cucumber.stepDef",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class RunAll {
}
