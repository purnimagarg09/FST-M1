package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity5 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Redmi Note 10S");

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".ui.ConversationListActivity");
        options.noReset();

        // Instantiate Appium Driver
        URL serverURL = new URL("http://localhost:4723/wd/hub");        //throws exception
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void sendMessage(){
        driver.findElement(AppiumBy.id("start_chat_fab")).click();
        driver.findElement(AppiumBy.id("recipient_text_view")).sendKeys("9711985485");
        driver.getKeyboard().sendKeys(Keys.ENTER);

        //Look for Message box
        driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
        driver.findElement(AppiumBy.id("send_message_button_icon")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("message_text")));
        String sentMessage = driver.findElement(AppiumBy.id("message_text")).getText();
        Assert.assertEquals(sentMessage,"Hello from Appium");
    }

    @AfterClass
    public void end(){
        driver.quit();
    }
}
