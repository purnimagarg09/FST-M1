package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6b {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/ajax");

        System.out.println("Page title : " + driver.getTitle());
        WebElement change=driver.findElement(By.xpath("//button[contains(text(), 'Change Content')]"));
        change.click();

        WebElement text=driver.findElement(By.xpath("//div[@id='ajax-content']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBePresentInElement(text,"HELLO!"));
        System.out.println("First Text : " + text.getText());

        wait.until(ExpectedConditions.textToBePresentInElement(text,"I'm late!"));
        WebElement later=driver.findElement(By.xpath("//div[@id='ajax-content']"));
        System.out.println("Later Text : " + later.getText());
        driver.close();
    }
}
