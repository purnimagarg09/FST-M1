package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @BeforeMethod
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void verifyTitle(){
        String title = driver.getTitle();
        System.out.println("Page title : "+title);
        Assert.assertEquals(title,"Target Practice");
    }

    @Test
    public void verifyBlack(){
        WebElement black = driver.findElement(By.xpath("//button[text()='Black']"));
        Assert.assertEquals(black.getText(),"black");
    }

    @Test(enabled = false)
    public void funcSkip(){
        System.out.println("This method will be skipped");
    }

    @Test()
    public void funcSkipExc() throws SkipException{
            throw new SkipException("Skipping the test run");
    }

    @AfterMethod
    public void end(){
        driver.close();
    }
}
