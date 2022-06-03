package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        String title = driver.getTitle();
        System.out.println("Page title : " + title);

        WebElement firstname=driver.findElement(By.id("firstName"));
        WebElement lastname=driver.findElement(By.id("lastName"));
        firstname.sendKeys("admin");
        lastname.sendKeys("password");

        WebElement email=driver.findElement(By.id("email"));
        WebElement contact=driver.findElement(By.id("number"));
        email.sendKeys("purnima.garg09@gmail.com");
        contact.sendKeys("9876543210");

        WebElement submitButton=driver.findElement(By.cssSelector(".ui.green.button"));
        submitButton.click();
        Thread.sleep(1000);
        driver.close();
    }
}
