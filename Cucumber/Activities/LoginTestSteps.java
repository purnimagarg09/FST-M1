package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps {
    WebDriver driver;
    WebDriverWait wait;

    @Given("^User is on Login page$")
    public void homePage() {
        driver = new FirefoxDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @When("^User enters username and password$")
    public void enterDetails() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void enterDetails(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @Then("^Read the page title and confirmation message$")
    public void displayResults() {
        String title = driver.getTitle();
        System.out.println("Page title: " + title);
        String result = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Confirmation message: " + result);
    }

    @And("^Close the Browser$")
    public void closeBrowser() {
        driver.close();
    }

}
