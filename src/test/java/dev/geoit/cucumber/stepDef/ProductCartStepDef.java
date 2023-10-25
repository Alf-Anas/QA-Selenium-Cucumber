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
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ProductCartStepDef {

    WebDriver driver = WebDriverSingleton.getDriver();
    String allItemsPage = "https://www.saucedemo.com/inventory.html";
    String cartPage = "https://www.saucedemo.com/cart.html";
    String btnAddToCartFirstItemXPath = "/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button";
    String titleFirstItemXPath = "/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[1]/a/div";
    String btnAddToCartSecondItemXPath = "/html/body/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[2]/button";
    String titleSecondItemXPath = "/html/body/div/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/a/div";
    String btnCartLinkXPath = "//*[@id=\"shopping_cart_container\"]/a";
    String inventoryItemClassName = "inventory_item_name";

    String btnRemoveLabel = "Remove";
    String btnAddToCartLabel = "Add to cart";

    String firstItemTitle = "";
    String secondItemTitle = "";

    @Given("The user is on the All Items page")
    public void theUserIsOnTheAllItemsPage() {
        // Verify the current URL
        String currentUrl = driver.getCurrentUrl();

        if (!allItemsPage.equals(currentUrl)) {
            driver.get(allItemsPage);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.urlToBe(allItemsPage));
            currentUrl = driver.getCurrentUrl();
        }

        assertEquals("The user is not on the All Items page", allItemsPage, currentUrl);
    }

    @When("The user clicks Add to Cart Button for the first item")
    public void theUserClicksAddToCartButtonForTheFirstItem() {
        WebElement firstItemTitleDiv = driver.findElement(By.xpath(titleFirstItemXPath));
        firstItemTitle = firstItemTitleDiv.getText();
        WebElement addToCartBtn = driver.findElement(By.xpath(btnAddToCartFirstItemXPath));
        if (addToCartBtn.getText().equals(btnAddToCartLabel)) {
            addToCartBtn.click();
        }
    }

    @And("The user clicks Add to Cart Button for the second item")
    public void theUserClicksAddToCartButtonForTheSecondItem() {
        WebElement secondItemTitleDiv = driver.findElement(By.xpath(titleSecondItemXPath));
        secondItemTitle = secondItemTitleDiv.getText();
        WebElement addToCartBtn = driver.findElement(By.xpath(btnAddToCartSecondItemXPath));
        if (addToCartBtn.getText().equals(btnAddToCartLabel)) {
            addToCartBtn.click();
        }
    }


    @And("The user opens the cart page by clicking the cart icon")
    public void theUserOpensTheCartPageByClickingTheCartIcon() {
        WebElement cartIcon = driver.findElement(By.xpath(btnCartLinkXPath));
        cartIcon.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.urlToBe(cartPage));
    }

    @Then("The user should be able to see the added items in the cart page")
    public void theUserShouldBeAbleToSeeTheAddedItemsInTheCartPage() {
        List<WebElement> inventoryItems = driver.findElements(By.className(inventoryItemClassName));

        for (WebElement item : inventoryItems) {
            String itemText = item.getText();
            assertTrue("Element text should contain either " + firstItemTitle + " or " + secondItemTitle,
                    itemText.contains(firstItemTitle) || itemText.contains(secondItemTitle));
        }
    }

    @And("The user clicks Remove Button for the first item")
    public void theUserClicksRemoveButtonForTheFirstItem() {
        WebElement firstItemTitleDiv = driver.findElement(By.xpath(titleFirstItemXPath));
        firstItemTitle = firstItemTitleDiv.getText();
        WebElement removeBtn = driver.findElement(By.xpath(btnAddToCartFirstItemXPath));
        if (removeBtn.getText().equals(btnRemoveLabel)) {
            removeBtn.click();
        }
    }

    @And("The user clicks Remove Button for the second item")
    public void theUserClicksRemoveButtonForTheSecondItem() {
        WebElement secondItemTitleDiv = driver.findElement(By.xpath(titleSecondItemXPath));
        secondItemTitle = secondItemTitleDiv.getText();
        WebElement removeBtn = driver.findElement(By.xpath(btnAddToCartSecondItemXPath));
        if (removeBtn.getText().equals(btnRemoveLabel)) {
            removeBtn.click();
        }
    }


    @Then("The removed items cannot be seen in the cart page")
    public void theRemovedItemsCannotBeSeenInTheCartPage() {
        List<WebElement> inventoryItems = driver.findElements(By.className(inventoryItemClassName));

        assertEquals("Element text should not contain either " + firstItemTitle + " or " + secondItemTitle, 0, inventoryItems.size());
    }

    @Then("Close Browser")
    public void closeBrowser() {
        WebDriverSingleton.closeDriver();
    }
}
