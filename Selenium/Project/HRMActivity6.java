package OrangeHRM_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class HRMActivity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test(priority = 1)
    @Parameters({"username","password"})
    public void login(String username, String password){
        WebElement user=driver.findElement(By.id("txtUsername"));
        WebElement pwd=driver.findElement(By.id("txtPassword"));
        user.sendKeys(username);
        pwd.sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();

        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }

    @Test(priority = 2)
    public void verifyDir(){
        WebElement dir = driver.findElement(By.linkText("Directory"));
        if(dir.isDisplayed()){
            System.out.println("Directory menu Item is visible on page");
            if(dir.isEnabled()){
                System.out.println("Directory menu Item is enabled on page");
                dir.click();
                dir.click();
            }
        }

        WebElement dirpage = driver.findElement(By.xpath("//div[@class='box searchForm toggableForm']/div/h1"));
        Assert.assertEquals(dirpage.getText(),"Search Directory");
    }

    @AfterClass
    public void end(){
        driver.close();
    }
}
