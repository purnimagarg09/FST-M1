package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8a {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/tables");

        List<WebElement> cols= driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[1]/td"));
        List<WebElement> rows= driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr"));

        System.out.println("Number of columns in table : " + cols.size());
        System.out.println("Number of rows in table : " + rows.size());

        //print the all the cell values of the third row of the table
        WebElement three=rows.get(2);
        System.out.println("Cell values of the third row of the table : " + three.getText());

        //print the cell value at the second row and second column.
        WebElement second= driver.findElement(By.xpath("//table[@class='ui celled striped table']/tbody/tr[2]/td[2]"));
        System.out.println("Cell value at the second row and second column :" + second.getText());

        driver.close();
    }
}
