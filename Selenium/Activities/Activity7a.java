package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7a {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-attributes");

        System.out.println("Page title : " + driver.getTitle());
        WebElement username=driver.findElement(By.xpath("//input[starts-with(@class, 'username-')]"));
        WebElement password=driver.findElement(By.xpath("//input[starts-with(@class, 'password-')]"));
        username.sendKeys("admin");
        password.sendKeys("password");

        WebElement login=driver.findElement(By.xpath("//button[contains(text(), 'Log in')]"));
        login.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")));

        System.out.println(driver.findElement(By.id("action-confirmation")).getText());

        driver.close();
    }
}
