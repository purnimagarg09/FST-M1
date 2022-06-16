package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {

    // Declare Android driver
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Redmi Note 10S");
        //If device name is not known , options.getDeviceName()

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.miui.calculator");
        options.setAppActivity(".cal.CalculatorActivity");
        options.noReset();

        // Instantiate Appium Driver
        URL serverURL = new URL("http://localhost:4723/wd/hub");        //throws exception
        driver = new AndroidDriver(serverURL, options);
    }

    @Test
    public void multiply(){
        WebElement num1 = driver.findElement(AppiumBy.id("com.miui.calculator:id/btn_5_s"));
        num1.click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("btn_8_s")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        //get the view where result is displayed
        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("Product of two number : "+result.substring(2));  //result value after =
        Assert.assertEquals(result.substring(2),"40");
    }

    @AfterClass
    public void end(){
        driver.quit();
    }
}
