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

public class Project_Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Redmi Note 10S");

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Instantiate Appium Driver
        URL serverURL = new URL("http://localhost:4723/wd/hub");        //throws exception
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void addTasks(){

        String[] tasks = {"Complete Activity with Google Tasks","Complete Activity with Google Keep",
        "Complete the second Activity Google Keep"};

        //Click the button to add a new task
        driver.findElement(AppiumBy.id("tasks_fab")).click();
        //Add the task
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("add_task_title")));
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys(tasks[0]);
        //Click on Save button
        driver.findElement(AppiumBy.id("add_task_done")).click();

        driver.findElement(AppiumBy.id("tasks_fab")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("add_task_title")));
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys(tasks[1]);
        driver.findElement(AppiumBy.id("add_task_done")).click();

        driver.findElement(AppiumBy.id("tasks_fab")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("add_task_title")));
        driver.findElement(AppiumBy.id("add_task_title")).sendKeys(tasks[2]);
        driver.findElement(AppiumBy.id("add_task_done")).click();

        List<WebElement> task= driver.findElements(AppiumBy.id("task_name"));
        System.out.println(task.size());
        int i=tasks.length-1;
        for (WebElement e : task) {
            System.out.println(e.getText());
            Assert.assertEquals(e.getText(),tasks[i]);
            i--;
        }
    }

    @AfterClass
    public void end(){
        driver.quit();
    }
}
