package OrangeHRM_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class HRMActivity5 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("http://alchemy.hguy.co/orangehrm");
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test()
    @Parameters({"username","password"})
    public void login(String username, String password){
        WebElement user=driver.findElement(By.id("txtUsername"));
        WebElement pwd=driver.findElement(By.id("txtPassword"));
        user.sendKeys(username);
        pwd.sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();

        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }

    @Test(dependsOnMethods = {"login"})
    public void editInfo() throws InterruptedException{

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_dashboard_index")));
        //Find the “My Info” menu item and click it
        WebElement info = driver.findElement(By.linkText("My Info"));
       info.click();
       info.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pdMainContainer")));
        //click the Edit button
        driver.findElement(By.xpath("//input[@id='btnSave' and @value='Edit']")).click();


        //Enter Name details
        WebElement fullfirstname = driver.findElement(By.id("personal_txtEmpFirstName"));
        fullfirstname.clear();
        fullfirstname.sendKeys("Test");
        WebElement fulllastname = driver.findElement(By.id("personal_txtEmpLastName"));
        fulllastname.clear();
        fulllastname.sendKeys("User");

        //Select Gender
        driver.findElement(By.id("personal_optGender_2")).click();
        Select select = new Select(driver.findElement(By.id("personal_cmbNation")));
        select.selectByVisibleText("Indian");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        String date= dateFormat.format(d);
        driver.findElement(By.id("personal_DOB")).clear();
        driver.findElement(By.id("personal_DOB")).sendKeys(date);

        //Saving the details
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='btnSave' and @value='Save']")).click();
        WebElement msg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='message success fadable']")));
        Assert.assertTrue(msg.getText().contains("Successfully Saved"));
    }

    @AfterClass
    public void end(){
        driver.close();
    }
}
