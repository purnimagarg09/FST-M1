package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11c {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        System.out.println("Page title : " + driver.getTitle());

        WebElement prompt = driver.findElement(By.id("prompt"));
        prompt.click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Text in alert box : "+alert.getText());
        Thread.sleep(1000);
        alert.sendKeys("Yes, you are!");
        alert.accept();

        driver.close();
    }
}
