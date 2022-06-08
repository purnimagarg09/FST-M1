package OrangeHRM_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HRMActivity8 {
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
    public void applyLeave() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='quickLinkText' and text()='Apply Leave']")));
        WebElement leave = driver.findElement(By.xpath("//span[@class='quickLinkText' and text()='Apply Leave']"));
        leave.click();
        leave.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='apply-leave']/div/h1")));

        //Add details
        Select select = new Select(driver.findElement(By.id("applyleave_txtLeaveType")));
        select.selectByVisibleText("DayOff");

        /*DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calndr = Calendar.getInstance();
        Date start = calndr.after(Calendar.DATE,7);
        Date end = calndr.after(Calendar.DATE,9);*/
        WebElement fromdate = driver.findElement(By.id("applyleave_txtFromDate"));
        fromdate.clear();
        fromdate.sendKeys("2022-06-29");
        WebElement toDate = driver.findElement(By.id("applyleave_txtToDate"));
        toDate.clear();
        toDate.sendKeys("2022-06-30");
        driver.findElement(By.id("applyBtn")).click();

        //Navigate to My Leave
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        WebElement search1 = driver.findElement(By.id("calFromDate"));
        search1.clear();
        search1.sendKeys("2022-06-29");
        WebElement search2=driver.findElement(By.id("calToDate"));
        search2.clear();
        search2.sendKeys("2022-06-30");
        driver.findElement(By.id("btnSearch")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultTable")));
        WebElement table = driver.findElement(By.id("resultTable"));
        List<WebElement> rows= driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
        System.out.println(rows.size());
        if(rows.size()>1){
            for(int i=1;i<=rows.size();i++){
                String status = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[i]/td[6]/a")).getText();
                System.out.println("Leave application "+i+" status : "+status);
            }
        }
        else{
            String status = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[1]/td[6]/a")).getText();
            System.out.println("Leave application status : "+status);
        }

        Assert.assertTrue(rows.size()>=1);
    }

    @AfterClass
    public void end(){
        driver.close();
    }
}
