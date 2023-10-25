package dev.geoit.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/dev/geoit/cucumber/features/product-cart.feature",
        glue = "dev.geoit.cucumber.stepDef",
        plugin = {"pretty", "html:target/cucumber-reports-product-cart.html"}
)
public class RunProductCart {
}
