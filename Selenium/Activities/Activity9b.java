package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9b {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");

        WebElement dropdown = driver.findElement(By.id("multi-select"));
        WebElement dropdowntext = driver.findElement(By.id("multi-value"));

        Select select = new Select(dropdown);

        //Check if the HTML element is a multi-list. Proceed with other actions if it is.
        if(select.isMultiple()){

            //Select the 'JavaScript' option by visible text.
            select.selectByVisibleText("Javascript");
            System.out.println(dropdowntext.getText());
            Thread.sleep(1000);

            //Select the 'NodeJS' option by value.
            select.selectByValue("node");
            System.out.println(dropdowntext.getText());
            Thread.sleep(1000);

            //Select the 4th, 5th, and the 6th options by index.
            select.selectByIndex(4);
            select.selectByIndex(5);
            select.selectByIndex(6);
            System.out.println(dropdowntext.getText());
            Thread.sleep(1000);

            //Deselect the 'NodeJS' option by value attribute.
            select.deselectByValue("node");
            System.out.println(dropdowntext.getText());
            Thread.sleep(1000);

            //Deselect the 7th option by index.
            select.deselectByIndex(7);
            System.out.println(dropdowntext.getText());
            Thread.sleep(1000);

            //Print the first selected option.
            System.out.println("First selected option : "+select.getFirstSelectedOption().getText());

            //Print all selected options one by one and deselect all options.
            List<WebElement> options = select.getAllSelectedOptions();
            System.out.println(("All selected options :"));
            for(WebElement i : options){
                System.out.println(i.getText());
            }
            select.deselectAll();
            System.out.println(dropdowntext.getText());
        }
        driver.close();
    }
}
