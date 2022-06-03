package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12c {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/popups");

        //Print the title of the page.
        System.out.println("Page title : " + driver.getTitle());

        WebElement signin = driver.findElement(By.className("orange"));
        Actions actions = new Actions(driver);

        actions.moveToElement(signin).build().perform();
        System.out.println("Button tooltip : "+signin.getAttribute("data-tooltip"));
        signin.click();

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        System.out.println(driver.findElement(By.id("action-confirmation")).getText());
        driver.close();
    }
}
