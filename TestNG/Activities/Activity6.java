package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;

    @BeforeClass
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    @Parameters({"username","password"})
    public void login(String username, String password){
        WebElement user=driver.findElement(By.id("username"));
        WebElement pwd=driver.findElement(By.id("password"));
        user.sendKeys(username);
        pwd.sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @AfterClass
    public void end(){
        driver.close();
    }
}
