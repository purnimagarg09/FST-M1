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

public class Project_Activity3 {
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
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void todoList() {
        driver.get("https://www.training-support.net/selenium");

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Selenium']")));

        //Scroll to end of page
        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator(
                "UiScrollable(new UiSelector().scrollable(true)).flingToEnd(3)"));
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@content-desc,'To-Do List')]")));
       driver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc,'To-Do List')]")).click();
       wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[contains(@text,'To-Do')]")));

        String[] tasks = {"Add tasks to list","Get number of tasks","Clear the list"};

       // find the input field on the page and enter the tasks
       driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys(tasks[0]);
       driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Task')]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys(tasks[1]);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Task')]")).click();

        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")).sendKeys(tasks[2]);
        driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text,'Task')]")).click();

        System.out.println("Tasks added");

        List<WebElement> task =driver.findElements(AppiumBy.xpath("//android.view.View[contains(@resource-id,'tasksList')]/android.view.View"));
        Assert.assertTrue(task.size()==4);

        int count=1;
        //Click on each of the tasks added to strike them out
        for (WebElement ele : task){
            if(count!=1){           //To skip the first default text from striking out
                ele.click();
            }
            count++;
        }

        //Clear the list  - View is clickable
        driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id='tasksCard']/android.view.View[3]")).click();
        List<WebElement> taskCards =driver.findElements(AppiumBy.xpath("//android.view.View[@resource-id='tasksCard']/android.view.View"));
        System.out.println("List Cleared");
        Assert.assertTrue(taskCards.size()==2);
    }

    @AfterClass
    public void end(){
        driver.quit();
    }
}
