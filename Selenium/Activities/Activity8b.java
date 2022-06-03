package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8b {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/tables");

        List<WebElement> cols= driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        List<WebElement> rows= driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));

        System.out.println("Number of columns in table : " + cols.size());
        System.out.println("Number of rows in table : " + rows.size());

        //print the cell value at the second row and second column.
        WebElement second= driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Cell value at the second row and second column :" + second.getText());

        Thread.sleep(2000);
        //Click the header of the first column to sort by name.
        WebElement firstcol=driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr[1]/th[1]"));
        firstcol.click();

        //print the cell value at the second row and second column again.
        WebElement second2= driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Cell value at the second row and second column after sorting by Name :" + second2.getText());

        //Print the cell values of the table footer.
        WebElement footer= driver.findElement(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
        System.out.println("Footer values : " + footer.getText());

        driver.close();
    }
}
