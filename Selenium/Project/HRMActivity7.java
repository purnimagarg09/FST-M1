package OrangeHRM_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class HRMActivity7 {
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
    public void addQual() throws InterruptedException{
        WebElement info = driver.findElement(By.linkText("My Info"));
        info.click();
        info.click();

        WebElement qual = driver.findElement(By.linkText("Qualifications"));
        qual.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='sectionWorkExperience']/div/h1")));
        driver.findElement(By.id("addWorkExperience")).click();

        //Add details
        driver.findElement(By.id("experience_employer")).sendKeys("IBM");
        driver.findElement(By.id("experience_jobtitle")).sendKeys("Test Specialist");
        driver.findElement(By.id("btnWorkExpSave")).click();

        WebElement msg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='message success fadable']")));
        Assert.assertTrue(msg.getText().contains("Successfully Saved"));

    }

    @AfterClass
    public void end(){
        driver.close();
    }
}
