package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {

    WebDriver driver;

    @BeforeMethod
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
    }

    @Test
    public void func(){
        String title = driver.getTitle();
        System.out.println("Page title : "+title);
        Assert.assertEquals(title,"Training Support");

        WebElement aboutUs = driver.findElement(By.id("about-link"));
        aboutUs.click();

        String aboutTitle = driver.getTitle();
        System.out.println("About Us Page title : "+aboutTitle);
        Assert.assertEquals(aboutTitle,"About Training Support");
    }

    @AfterMethod
    public void end(){
        driver.close();
    }
}
