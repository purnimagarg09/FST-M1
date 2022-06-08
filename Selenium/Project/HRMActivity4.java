package OrangeHRM_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class HRMActivity4{
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
    public void addEmployee() throws InterruptedException{

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_dashboard_index")));
        //Locate PIM Menu item
        WebElement pim = driver.findElement(By.id("menu_pim_viewPimModule"));
        pim.click();pim.click();
        //Locate and click Add button
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        Thread.sleep(1000);

        String firstname="Purnima";
        String lastname = "Garg";
        //Enter Required field details
        driver.findElement(By.id("firstName")).sendKeys(firstname);
        driver.findElement(By.id("lastName")).sendKeys(lastname);

        //Click save
        driver.findElement(By.id("btnSave")).click();
        //Navigate back to the PIM page (Employee List tab)
        driver.findElement(By.id("menu_pim_viewEmployeeList")).click();
        //Search for the Employee
        driver.findElement(By.id("empsearch_employee_name_empName")).sendKeys(firstname);
        driver.findElement(By.id("searchBtn")).click();

        WebElement result = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr/td[3]"));
        Assert.assertEquals(result.getText(),firstname);

    }

    @AfterClass
    public void end(){
        driver.close();
    }
}
