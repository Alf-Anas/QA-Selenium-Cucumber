package dev.geoit.cucumber.stepDef;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class LoginStepDef {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    String btnLoginId = "login-button";
    String inputUsernameId = "user-name";
    String inputPasswordId = "password";
    String pageInventory = "inventory.html";
    String errorDivXPath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3";

    @Given("The Saucedemo application is open")
    public void theSaucedemoApplicationIsOpen() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

        // Check that the application is ready
        assertTrue("The Saucedemo application did not load successfully",
                driver.findElement(By.id(btnLoginId)).isDisplayed());
    }

    @When("The user enters the valid username {string}")
    public void theUserEntersTheValidUsername(String username) {
        WebElement usernameField = driver.findElement(By.id(inputUsernameId));
        usernameField.sendKeys(username);
    }

    @And("The user enters the valid password {string}")
    public void theUserEntersTheValidPassword(String password) {
        WebElement passwordField = driver.findElement(By.id(inputPasswordId));
        passwordField.sendKeys(password);
    }

    @And("Clicks the Login button")
    public void clicksTheLoginButton() {
        WebElement loginButton = driver.findElement(By.id(btnLoginId));
        loginButton.click();
    }

    @Then("The user should be logged in successfully")
    public void theUserShouldBeLoggedInSuccessfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlToBe(baseUrl + pageInventory));

        // Verify the current URL
        String currentUrl = driver.getCurrentUrl();
        assertEquals("The user is not on the expected page after login", baseUrl + pageInventory, currentUrl);
    }

    @When("The user enters the invalid username {string}")
    public void theUserEntersTheInvalidUsername(String username) {
        WebElement usernameField = driver.findElement(By.id(inputUsernameId));
        usernameField.sendKeys(username);
    }

    @And("The user enters the invalid password {string}")
    public void theUserEntersTheInvalidPassword(String password) {
        WebElement passwordField = driver.findElement(By.id(inputPasswordId));
        passwordField.sendKeys(password);
    }

    @Then("The user should not be able to log in")
    public void theUserShouldNotBeAbleToLogIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2)); // Adjust the timeout as needed

        // Wait until the element is present in the DOM
        WebElement errorDiv = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(errorDivXPath)));
        assertTrue("Login was not successful", errorDiv.isDisplayed());
    }

    @After
    public void closeBrowser() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
