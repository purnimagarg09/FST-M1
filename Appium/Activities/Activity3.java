package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {
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
    public void add(){
        driver.findElement(AppiumBy.accessibilityId("clear")).click();
        driver.findElement(AppiumBy.id("btn_5_s")).click();
        driver.findElement(AppiumBy.accessibilityId("plus")).click();
        driver.findElement(AppiumBy.id("btn_9_s")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        //get the view where result is displayed
        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("Sum of two numbers : "+result.substring(2));  //result value after =
        Assert.assertEquals(result.substring(2),"14");
    }

    @Test
    public void subtract(){
        driver.findElement(AppiumBy.accessibilityId("clear")).click();
        driver.findElement(AppiumBy.id("btn_1_s")).click();
        driver.findElement(AppiumBy.id("btn_0_s")).click();
        driver.findElement(AppiumBy.accessibilityId("minus")).click();
        driver.findElement(AppiumBy.id("btn_5_s")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        //get the view where result is displayed
        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("Difference of two numbers : "+result.substring(2));  //result value after =
        Assert.assertEquals(result.substring(2),"5");
    }

    @Test
    public void product(){
        driver.findElement(AppiumBy.accessibilityId("clear")).click();
        driver.findElement(AppiumBy.id("btn_5_s")).click();
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();
        driver.findElement(AppiumBy.id("btn_1_s")).click();
        driver.findElement(AppiumBy.id("btn_0_s")).click();
        driver.findElement(AppiumBy.id("btn_0_s")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        //get the view where result is displayed
        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("Product of two numbers : "+result.substring(2));  //result value after =
        Assert.assertEquals(result.substring(2),"500");
    }

    @Test
    public void divide(){
        driver.findElement(AppiumBy.accessibilityId("clear")).click();
        driver.findElement(AppiumBy.id("btn_5_s")).click();
        driver.findElement(AppiumBy.id("btn_0_s")).click();
        driver.findElement(AppiumBy.accessibilityId("divide")).click();
        driver.findElement(AppiumBy.id("btn_2_s")).click();
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        //get the view where result is displayed
        String result = driver.findElement(AppiumBy.id("result")).getText();
        System.out.println("Division of two numbers : "+result.substring(2));  //result value after =
        Assert.assertEquals(result.substring(2),"25");
    }

    @AfterClass
    public void end(){
        driver.quit();
    }
}
