package dev.geoit.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static junit.framework.Assert.assertEquals;

public class LogoutStepDef {

    WebDriver driver = WebDriverSingleton.getDriver();
    String loginPage = "https://www.saucedemo.com/";

    String btnMenuXPath = "//*[@id=\"react-burger-menu-btn\"]";
    String btnLogoutXPath = "/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[3]";

    @When("The user clicks Menu Button in the sidebar")
    public void theUserClicksMenuButtonInTheSidebar() {
        WebElement menuBtn = driver.findElement(By.xpath(btnMenuXPath));
        menuBtn.click();
    }

    @And("The user clicks Logout Button in the sidebar")
    public void theUserClicksLogoutButtonInTheSidebar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(btnLogoutXPath)));
        logoutBtn.click();
    }

    @And("The user get back to login page")
    public void theUserGetBackToLoginPage() {
        // Verify the current URL
        String currentUrl = driver.getCurrentUrl();
        assertEquals("The user is not on the Login page", loginPage, currentUrl);
    }

}
