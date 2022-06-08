package OrangeHRM_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

//Verify the website title
public class HRMActivity1 {
    WebDriver driver;

    @BeforeMethod
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
    }

    @Test
    public void verifyTitle(){
        String title = driver.getTitle();
        System.out.println("Page title : "+title);
        Assert.assertEquals(title,"OrangeHRM");
    }

    @AfterMethod
    public void end(){
        driver.close();
    }

}
