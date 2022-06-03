package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;

    @BeforeMethod(alwaysRun=true)       //always Run to ensure this run despite of which group executed
    public void initialize(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void verifyTitle(){
        String title = driver.getTitle();
        System.out.println("Page title : "+title);
        Assert.assertEquals(title,"Target Practice");
    }

    @Test(groups = {"HeaderTests"})
    public void verifyHeader3(){
        WebElement third = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals(third.getText(),"Third header");
    }

    @Test(groups = {"HeaderTests"})
    public void verifyHeader5(){
        WebElement fifth = driver.findElement(By.xpath("//h5"));
       // Assert.assertEquals(fifth.getCssValue("Color"),"green");
        Assert.assertEquals(fifth.getCssValue("Color"),"rgb(33, 186, 69)");
    }

    @Test(groups = {"ButtonTests"})
    public void verifyOlive(){
        WebElement olive = driver.findElement(By.xpath("//button[text()='Olive']"));
        Assert.assertEquals(olive.getText(),"Olive");
    }

    @Test(groups = {"ButtonTests"})
    public void verifyFirstButton(){
        WebElement firstButton = driver.findElement(By.xpath("//button[text()='Brown']"));
        //Assert.assertEquals(firstButton.getCssValue("color"),"Brown");
        Assert.assertEquals(firstButton.getCssValue("color"),"rgb(255, 255, 255)");
    }

    @AfterMethod(alwaysRun=true)
    public void end(){
        driver.close();
    }
}
