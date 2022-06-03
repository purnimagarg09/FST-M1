package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4a {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net");

        System.out.println("Page title : " + driver.getTitle());
        WebElement about = driver.findElement(By.xpath("//div[@class='ui text container']/a"));
        Thread.sleep(1000);
        about.click();

        System.out.println("New Page title : " + driver.getTitle());
        driver.close();
    }
}
