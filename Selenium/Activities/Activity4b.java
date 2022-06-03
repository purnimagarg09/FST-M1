package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4b {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/simple-form");

        System.out.println("Page title : " + driver.getTitle());
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Purnima");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Garg");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@gmail.com");
        driver.findElement(By.xpath("//input[@id='number']")).sendKeys("9876543210");
        driver.findElement(By.xpath("//div[@class='field']/textarea")).sendKeys("Test entry");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='submit']")).click();

        driver.close();
    }

}
