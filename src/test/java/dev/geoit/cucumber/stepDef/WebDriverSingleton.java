package dev.geoit.cucumber.stepDef;

import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {
    private static WebDriver driver;

    private WebDriverSingleton() {
        // private constructor to enforce Singleton pattern
    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset the instance
        }
    }
}
