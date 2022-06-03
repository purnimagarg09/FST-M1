package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12b {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/nested-iframes");

        //Print the title of the page.
        System.out.println("Page title : " + driver.getTitle());

        //Traverse into the iframe that is on the page.
        driver.switchTo().frame(0);

        //Traverse into the first iframe in that frame.
        driver.switchTo().frame(0);

        //Print the heading of that frame.
        WebElement heading1 = driver.findElement(By.cssSelector("div.content"));
        System.out.println("First frame heading : "+heading1.getText());

        driver.switchTo().defaultContent(); //switches control to parent - base level page
        driver.switchTo().frame(0);     //switches back to first level
        //Navigate to the second iframe in that frame
        driver.switchTo().frame(1);
        //Print the heading of that frame
        WebElement heading2 = driver.findElement(By.cssSelector("div.content"));
        System.out.println("Second frame heading : "+heading2.getText());

        driver.close();
    }
}

