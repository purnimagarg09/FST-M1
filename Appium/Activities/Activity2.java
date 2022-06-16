package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Redmi Note 10S");
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        URL serverURL = new URL("http://localhost:4723/wd/hub");        //throws exception
        driver = new AndroidDriver(serverURL, options);
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void aboutUs(){
        driver.get("https://www.training-support.net/");

        WebElement home = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text()='Training Support']"));
        System.out.println("Home Page Heading : "+home.getText());

        WebElement about = driver.findElement(AppiumBy.id("about-link"));
        about.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text()='About Us']")));
        WebElement aboutUsPage=driver.findElement(AppiumBy.xpath("\"//android.widget.TextView[@text()='About Us']\""));
        System.out.println("About Us Page Heading : "+aboutUsPage.getText());

        Assert.assertEquals(home.getText(),"Training Support");
        Assert.assertEquals(aboutUsPage.getText(),"About Us");
    }

    @AfterClass
    public void end(){
        driver.quit();
    }
}
