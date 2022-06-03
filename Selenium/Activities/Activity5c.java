package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5c {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");

        System.out.println("Page title : " + driver.getTitle());

        WebElement text=driver.findElement(By.xpath("//input[@id='input-text']"));
        System.out.println("Textbox enabled on page : " +text.isEnabled());

        driver.findElement(By.xpath("//button[@id='toggleInput']")).click();
        System.out.println("Textbox enabled later on page : " +text.isEnabled());

        driver.close();
    }
}
