package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10c {
            public static void main(String[] args) throws InterruptedException {

            WebDriver driver = new FirefoxDriver();
            driver.get("https://training-support.net/selenium/drag-drop");

            System.out.println("Page title : " + driver.getTitle());
            WebElement ball = driver.findElement(By.id("draggable"));

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            Actions actions= new Actions(driver);
            WebElement dropzone1 = driver.findElement(By.id("droppable"));
            WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

            actions.dragAndDrop(ball,dropzone1).build().perform();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='droppable']/p"),"Dropped"));
            System.out.println("Ball dragged and dropped to Zone1");

            actions.dragAndDrop(ball,dropzone2).build().perform();
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='dropzone2']/p"),"Dropped"));
            System.out.println("Ball dragged and dropped to Zone2");

            driver.close();
        }
}
