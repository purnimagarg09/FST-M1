package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5a {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");

        System.out.println("Page title : " + driver.getTitle());

        WebElement checkbox=driver.findElement(By.xpath("//input[@name='toggled']"));
        System.out.println("Checkbox visible on page : " +checkbox.isDisplayed());

        driver.findElement(By.id("toggleCheckbox")).click();
        System.out.println("Checkbox visible on page : " +checkbox.isDisplayed());

        driver.close();
    }
}
