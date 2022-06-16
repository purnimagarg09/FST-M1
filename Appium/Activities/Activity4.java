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

public class Activity4 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Redmi Note 10S");

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.dialer");
        options.setAppActivity(".extensions.GoogleDialtactsActivity");
        options.noReset();

        // Instantiate Appium Driver
        URL serverURL = new URL("http://localhost:4723/wd/hub");        //throws exception
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void addContact(){
        driver.findElement(AppiumBy.id("com.google.android.dialer:id/contact_name")).click();

       wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text='Name']")));
        //Entering contact details
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Name']")).sendKeys("Test User");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("9876543210");

        //Click on Save button
        driver.findElement(AppiumBy.id("com.google.android.contacts:id/toolbar_button")).click();

        //Capture the Toast Confirmation message
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("/hierarchy/android.widget.Toast")));
        String toastMessage = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.Toast")).getText();
        System.out.println(toastMessage);

        Assert.assertEquals(toastMessage,"Test User saved");
    }

    @AfterClass
    public void end(){
        driver.quit();
    }
}
