package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10a {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/input-events");

        System.out.println("Page title : " + driver.getTitle());

        WebElement cube = driver.findElement(By.id("wrapD3Cube"));
        Actions action = new Actions(driver);

        //Left click and print the value of the side in the front.
        action.click(cube);
        WebElement front = driver.findElement(By.xpath("//div[@class='active']"));
        System.out.println("Side in front has value : "+ front.getText());
        Thread.sleep(2000);

        //Double click to show a random side and print the number.
        action.doubleClick(cube).perform();
        WebElement rand = driver.findElement(By.xpath("//div[@class='active']"));
        System.out.println("Side after double click has value : "+ rand.getText());
        Thread.sleep(2000);

        //Right click and print the value shown on the front of the cube.
        action.contextClick(cube).perform();
        WebElement right = driver.findElement(By.xpath("//div[@class='active']"));
        System.out.println("Side after right click has value : "+ right.getText());
        Thread.sleep(1000);

        driver.close();
    }
}
