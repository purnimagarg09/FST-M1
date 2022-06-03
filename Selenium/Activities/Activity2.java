package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/");
        String title = driver.getTitle();
        System.out.println("Page title : " + title);

        WebElement id = driver.findElement(By.id("about-link"));
        System.out.println("Text in WebElement using id : " + id.getText());

        //Argument in classname should be only 1 word, as it cannot accept more than one argument.
        //Every word in classname attribute in html tag is an individual class, so we can choose any one classname
        WebElement classelement = driver.findElement(By.className("huge"));
        System.out.println("Text in WebElement using ClassName : " + classelement.getText());

        WebElement linktext = driver.findElement(By.linkText("About Us"));
        System.out.println("Text in WebElement using LinkText : " + linktext.getText());

        //here our element has id attribute, so we can use css selector with id attribute. It is not mandatory for
        //this to appear in stylesheet file or use multiple classes to make it unique like ".huge.green.button"
        WebElement css = driver.findElement(By.cssSelector("#about-link"));
        System.out.println("Text in WebElement using CssSelector : " + css.getText());

        driver.close();
    }
}