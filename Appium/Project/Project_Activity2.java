package liveProject;

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
import java.util.List;

public class Project_Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Redmi Note 10S");

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Instantiate Appium Driver
        URL serverURL = new URL("http://localhost:4723/wd/hub");        //throws exception
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void addNote(){

        List<WebElement> notes_before = driver.findElements(AppiumBy.id("browse_note_interior_content"));
        int count_before = notes_before.size();
        System.out.println(count_before);

        //Click the button to add a new task
        driver.findElement(AppiumBy.id("new_note_button")).click();

        //Add the note title
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("editable_title")));
        driver.findElement(AppiumBy.id("editable_title")).sendKeys("Test Note");

        //Add the note description
       // wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("edit_note_text")));
        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys("Add a title for the note and add a small description.");

        //Click on Back button
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();

        List<WebElement> notes_after = driver.findElements(AppiumBy.id("browse_note_interior_content"));
        System.out.println(notes_after.size());
        //Validating a new Note is added
        Assert.assertTrue(notes_after.size()==count_before+1);

    }

    @AfterClass
    public void end(){
        driver.quit();
    }
}
