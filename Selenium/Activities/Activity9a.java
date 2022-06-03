package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9a {
    public static void main(String[] args) throws InterruptedException{

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");

        WebElement dropdown = driver.findElement(By.id("single-select"));
        WebElement dropdowntext = driver.findElement(By.id("single-value"));
        Select select = new Select(dropdown);

        //Select the second option using selectByVisibleText()
        select.selectByVisibleText("Option 2");
        System.out.println(dropdowntext.getText());
        Thread.sleep(1000);

        //Select the third option using selectByIndex()
        select.selectByIndex(3);
        System.out.println(dropdowntext.getText());
        Thread.sleep(1000);

        //Select the fourth option using selectByValue()
        select.selectByValue("4");
        System.out.println(dropdowntext.getText());
        Thread.sleep(1000);

        //Get all the options in the dropdown and print them one by one.
        List<WebElement> options = select.getOptions();
        System.out.println("All options: ");
        for(WebElement i : options)
            System.out.println(i.getText());

        driver.close();
    }
}
