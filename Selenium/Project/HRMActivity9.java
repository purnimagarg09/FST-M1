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
import java.util.List;

public class HRMActivity9 {
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
    public void emerContact(){
        WebElement info = driver.findElement(By.linkText("My Info"));
        info.click();
        info.click();

        WebElement cnt = driver.findElement(By.linkText("Emergency Contacts"));
        cnt.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='listEmegrencyContact']/div/h1")));

        List<WebElement> rows= driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr"));
        List<WebElement> cols= driver.findElements(By.xpath("//table[@id='emgcontact_list']/tbody/tr[1]/td"));
        System.out.println("Number of emergency contacts : "+rows.size());
        System.out.println("Emergency Contact details : ");
        System.out.println();

        //Printing table headers
        for(int j=2;j<=cols.size();j++) {
            System.out.print(driver.findElement(By.xpath("//table[@id='emgcontact_list']/thead/tr[1]/th["+j+"]")).getText() + "\t");
        }

        //Printing table contents
        System.out.println();
        for(int i=1;i<= rows.size();i++){
            for(int j=2;j<=cols.size();j++) {
                System.out.print(driver.findElement(By.xpath("//table[@id='emgcontact_list']/tbody/tr["+i+"]/td["+j+"]")).getText() + "\t");
            }
            System.out.println();
        }

    }

    @AfterClass
    public void end(){

        driver.close();
    }
}
