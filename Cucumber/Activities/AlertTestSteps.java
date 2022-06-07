package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTestSteps {
    WebDriver driver;
    WebDriverWait wait;
    Alert alert;
    @Given("^User is on the page$")
    public void alertPage() {
        driver = new FirefoxDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @When("^User clicks the Simple Alert button$")
    public void clickSimple() {
        driver.findElement(By.id("simple")).click();
    }

    @When("^User clicks the Confirm Alert button$")
    public void clickConfirm() {
        driver.findElement(By.id("confirm")).click();
    }

    @When("^User clicks the Prompt Alert button$")
    public void clickPrompt() {
        driver.findElement(By.id("prompt")).click();
    }

    @Then("^Alert opens$")
    public void openAlert() {
        alert = driver.switchTo().alert();
    }

    @And("^Read the text from it and print it$")
    public void readText() {
        System.out.println("Alert text: "+alert.getText());
    }

    @And("^Write a custom message in it$")
    public void writeText() {
        alert.sendKeys("This is Test alert");
    }

    @And("^Close the alert$")
    public void closeAlert() {
        alert.accept();
    }

    @And("^Close the alert with Cancel$")
    public void cancelAlert() {
        alert.dismiss();
    }
    @And("^Close Browser$")
    public void close_Browser() {
        driver.close();
    }
}
