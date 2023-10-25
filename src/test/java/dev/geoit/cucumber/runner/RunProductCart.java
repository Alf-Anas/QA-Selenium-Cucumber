package dev.geoit.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/dev/geoit/cucumber/features", glue = "dev.geoit.cucumber.stepDef")
public class RunLogin {
}
