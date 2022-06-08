package OrangeHRM_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HRMActivity3 {
    WebDriver driver;

    @BeforeMethod
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    @Parameters({"username","password"})
    public void login(String username, String password){
        WebElement user=driver.findElement(By.id("txtUsername"));
        WebElement pwd=driver.findElement(By.id("txtPassword"));
        user.sendKeys(username);
        pwd.sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();

        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }

    @AfterMethod
    public void end(){
        driver.close();
    }
}
