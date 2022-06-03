package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6a {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");

        System.out.println("Page title : " + driver.getTitle());
        WebElement button=driver.findElement(By.id("toggleCheckbox"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("toggled")));
        System.out.println("Checkbox disappeared");
        button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("toggled")));
        System.out.println("Checkbox reappeared");

        driver.close();
    }
}
