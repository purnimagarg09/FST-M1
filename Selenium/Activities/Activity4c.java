package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4c {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");

        System.out.println("Page title : " + driver.getTitle());

        WebElement third = driver.findElement(By.xpath("//h3[@id='third-header']"));
        System.out.println("Third header on the page : "+third.getText());

        WebElement fifth = driver.findElement(By.xpath("//h5"));
        System.out.println("Third header on the page : "+third.getText() + " and it's color is : "+third.getCssValue("color"));

        WebElement violet = driver.findElement(By.xpath("//button[@class='ui violet button']"));
        System.out.println("Violet button attributes : "+violet.getAttribute("class"));

        WebElement grey = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
        System.out.println("Grey button details : "+grey.getText());

        driver.close();
    }
}
