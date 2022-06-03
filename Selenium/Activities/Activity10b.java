package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10b {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/input-events");

        System.out.println("Page title : " + driver.getTitle());
        Actions actions = new Actions(driver);

        //Press the key of your first name in caps
        actions.sendKeys("P").build().perform();
        Thread.sleep(1000);
        System.out.println("Key Pressed : "+driver.findElement(By.id("keyPressed")).getText());

        //Press CTRL+a and the CTRL+c to copy all the text on the page.
        actions.sendKeys(Keys.CONTROL,"a").build().perform();
        Thread.sleep(1000);
        System.out.println("Key Pressed : "+driver.findElement(By.id("keyPressed")).getText());
        actions.sendKeys(Keys.CONTROL,"c").build().perform();
        Thread.sleep(1000);
        System.out.println("Key Pressed : "+driver.findElement(By.id("keyPressed")).getText());

        driver.close();
    }
}
