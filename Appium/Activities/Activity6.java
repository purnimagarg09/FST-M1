package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity6 {
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
    public void scrollHelen() {
        driver.get("https://www.training-support.net/selenium/lazy-loading");

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Lazy Loading']")));
        List<WebElement> images = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("Number of images in current view : "+images.size());

        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(
                "UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"helen\")"));
        List<WebElement> images2 = driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("Number of images in current view at helen post : "+images2.size());
    }

    @AfterClass
    public void end(){
        driver.quit();
    }
}
