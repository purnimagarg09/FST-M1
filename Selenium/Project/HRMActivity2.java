package OrangeHRM_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Get the url of the header image
public class HRMActivity2 {
    WebDriver driver;

    @BeforeMethod
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void getHeader(){
        WebElement img = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
        Assert.assertTrue(img.isDisplayed());
        System.out.println(" Url of the Header image : "+img.getAttribute("src"));
    }

    @AfterMethod
    public void end(){
        driver.close();
    }
}
