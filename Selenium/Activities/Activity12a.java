package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12a {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/iframes");

        System.out.println("Page title : " + driver.getTitle());

        driver.switchTo().frame(0);
        WebElement heading1 = driver.findElement(By.cssSelector("div.content"));
        System.out.println("First frame heading : "+heading1.getText());

        WebElement button1 = driver.findElement(By.id("actionButton"));
        System.out.println("Button text in frame1 : "+button1.getText());
        System.out.println("Button color in frame1 : "+button1.getCssValue("color"));
        button1.click();

        System.out.println("Button text in frame1 after click: "+button1.getText());
        System.out.println("Button color in frame1 after click: "+button1.getCssValue("background-color"));

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        WebElement heading2 = driver.findElement(By.cssSelector("div.content"));
        System.out.println("Second frame heading : "+heading2.getText());

        WebElement button2 = driver.findElement(By.id("actionButton"));
        System.out.println("Button text in frame2 : "+button2.getText());
        System.out.println("Button color in frame2 : "+button2.getCssValue("background-color"));
        button2.click();

        System.out.println("Button text in frame2 after click: "+button2.getText());
        System.out.println("Button color in frame2 after click: "+button2.getCssValue("color"));
        driver.close();

    }
}
