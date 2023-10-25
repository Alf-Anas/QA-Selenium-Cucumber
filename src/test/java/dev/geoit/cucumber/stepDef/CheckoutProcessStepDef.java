package dev.geoit.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static junit.framework.Assert.assertEquals;

public class CheckoutProcessStepDef {

    WebDriver driver = WebDriverSingleton.getDriver();
    String cartPage = "https://www.saucedemo.com/cart.html";
    String checkoutPage = "https://www.saucedemo.com/checkout-step-one.html";
    String overviewPage = "https://www.saucedemo.com/checkout-step-two.html";
    String btnCheckoutXPath = "//*[@id=\"checkout\"]";
    String inputFirstNameXPath = "//*[@id=\"first-name\"]";
    String inputLastNameXPath = "//*[@id=\"last-name\"]";
    String inputZipCodeXPath = "//*[@id=\"postal-code\"]";
    String btnContinueXPath = "//*[@id=\"continue\"]";

    @Given("The user is on the cart page")
    public void theUserIsOnTheCartPage() {
        // Verify the current URL
        String currentUrl = driver.getCurrentUrl();

        if (!cartPage.equals(currentUrl)) {
            driver.get(cartPage);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.urlToBe(cartPage));
            currentUrl = driver.getCurrentUrl();
        }

        assertEquals("The user is not on the Cart page", cartPage, currentUrl);
    }

    @When("The user clicks the Checkout button")
    public void theUserClicksTheCheckoutButton() {
        WebElement checkoutButton = driver.findElement(By.xpath(btnCheckoutXPath));
        checkoutButton.click();
    }

    @And("The user is on the checkout page")
    public void theUserIsOnTheCheckoutPage() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("The user is not on the Checkout page", checkoutPage, currentUrl);
    }

    @And("The user inputs the valid First Name {string}")
    public void theUserInputsTheValidFirstName(String firstName) {
        WebElement firstNameField = driver.findElement(By.xpath(inputFirstNameXPath));
        firstNameField.sendKeys(firstName);
    }

    @And("The user inputs the valid Last Name {string}")
    public void theUserInputsTheValidLastName(String lastName) {
        WebElement lastNameField = driver.findElement(By.xpath(inputLastNameXPath));
        lastNameField.sendKeys(lastName);
    }

    @And("The user inputs the valid ZIP Code number {string}")
    public void theUserInputsTheValidZIPCodeNumber(String zipCode) {
        WebElement zipCodeField = driver.findElement(By.xpath(inputZipCodeXPath));
        zipCodeField.sendKeys(zipCode);
    }

    @And("The user clicks Continue")
    public void theUserClicksContinue() {
        WebElement continueButton = driver.findElement(By.xpath(btnContinueXPath));
        continueButton.click();
    }

    @Then("The user should be able to proceed to the checkout overview")
    public void theUserShouldBeAbleToProceedToTheCheckoutOverview() {
        // Verify the current URL
        String currentUrl = driver.getCurrentUrl();
        assertEquals("The user is not on the Overview page", overviewPage, currentUrl);
    }

    @And("The user inputs the invalid ZIP Code using the string value {string}")
    public void theUserInputsTheInvalidZIPCodeUsingTheStringValue(String zipCode) {
        WebElement zipCodeField = driver.findElement(By.xpath(inputZipCodeXPath));
        zipCodeField.sendKeys(zipCode);
    }

    @Then("The user should not be able to proceed to the checkout overview")
    public void theUserShouldNotBeAbleToProceedToTheCheckoutOverview() {
        // Verify the current URL
        String currentUrl = driver.getCurrentUrl();
        assertEquals("The user should stay in checkout page", checkoutPage, currentUrl);
    }


}
