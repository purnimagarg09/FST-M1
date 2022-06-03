package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Activity7 {
    WebDriver driver;

    @BeforeMethod
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                { "testuser_1", "Test@123" },
                { "testuser_2", "Test@456" }
        };
    }

    @Test(dataProvider = "Authentication")
    public void login(String username, String password) {

        WebElement user=driver.findElement(By.id("username"));
        WebElement pwd=driver.findElement(By.id("password"));
        user.sendKeys(username);
        pwd.sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @AfterMethod
    public void end(){
        driver.close();
    }
}
