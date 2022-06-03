package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Activity11d {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/tab-opener");

        System.out.println("Page title : " + driver.getTitle());
        System.out.println("Page Handle : "+driver.getWindowHandle());

        WebElement tab = driver.findElement(By.id("launcher"));
        tab.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> allHandles= driver.getWindowHandles();
        System.out.println("All window handles : "+ allHandles);

        for (String s : allHandles){
            driver.switchTo().window(s);
        }

        System.out.println("Current window handle : "+driver.getWindowHandle());

        wait.until(ExpectedConditions.titleIs("Newtab"));
        System.out.println("Second Page title : "+ driver.getTitle());
        WebElement h = driver.findElement(By.cssSelector("div.content"));
        System.out.println("Second Page Heading : "+h.getText());

        WebElement tab2 = driver.findElement(By.id("actionButton"));
        tab2.click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        Set<String> allHandles2= driver.getWindowHandles();
        System.out.println("All window handles in new tab : "+ allHandles2);

        driver.quit();
    }
}
