package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Activity9 {
    WebDriver driver;

    @BeforeTest
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @BeforeMethod
    public void mainPage(){
        driver.switchTo().defaultContent();
    }

    @Test
    public void simpleAlertTestCase() {
        WebElement simple = driver.findElement(By.id("simple"));
        simple.click();
        Reporter.log("Simple Alert opened");

        Alert alert = driver.switchTo().alert();
        System.out.println("Text in alert box : "+alert.getText());
        Assert.assertEquals(alert.getText(),"This is a JavaScript Alert!");

        alert.accept();
        Reporter.log("Simple Alert closed");
    }

    @Test
    public void confirmAlertTestCase(){
        WebElement confirm = driver.findElement(By.id("confirm"));
        confirm.click();
        Reporter.log("Confirm Alert opened");

        Alert alert = driver.switchTo().alert();
        System.out.println("Text in alert box : "+alert.getText());
        alert.accept();
        Reporter.log("Confirm Alert Accepted");

        confirm.click();
        Alert alert1 = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"This is a JavaScript Confirmation!");
        alert1.dismiss();
        Reporter.log("Confirm Alert Cancelled");
    }

    @Test
    public void promptAlertTestCase(){
        WebElement prompt = driver.findElement(By.id("prompt"));
        prompt.click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Text in alert box : "+alert.getText());

        alert.sendKeys("Yes, you are!");
        alert.accept();
        Reporter.log("Prompt Alert Accepted");

        prompt.click();
        Alert alert1 = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"This is a JavaScript Prompt!");
        alert1.dismiss();
        Reporter.log("Prompt Alert Cancelled");
    }

    @AfterTest
    public void end(){
        driver.close();
    }
}
