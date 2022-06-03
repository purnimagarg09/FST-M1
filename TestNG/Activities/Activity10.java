package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity10 {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    public void initialize(){
        driver = new FirefoxDriver();
        actions = new Actions(driver);
        driver.get("https://www.training-support.net/selenium/sliders");
    }

    @BeforeMethod
    public void refreshPage(){
        driver.navigate().refresh();
    }

    @Test
    public void middle_slider(){
        WebElement slider = driver.findElement(By.id("slider"));
        WebElement volume = driver.findElement(By.id("value"));

        /*  Unable to get exact XOffset value to move slider
        actions.clickAndHold(slider).moveByOffset(15, 0).release().build().perform();
        */

        while(Integer.parseInt(volume.getText())<50) {
            actions.moveToElement(slider).click(slider).sendKeys(Keys.ARROW_UP).perform();
        }
        System.out.println("Middle Value in slider : " + volume.getText() + "%");
        Assert.assertEquals(volume.getText(),"50");
    }

    @Test
    public void right_end_slider(){
        WebElement slider = driver.findElement(By.id("slider"));
        WebElement volume = driver.findElement(By.id("value"));
        System.out.println(volume.getText());
        while(Integer.parseInt(volume.getText())<100) {
            actions.moveToElement(slider).click(slider).sendKeys(Keys.ARROW_UP).perform();
        }
        System.out.println("Right end Value in slider : " + volume.getText() + "%");
        Assert.assertEquals(volume.getText(),"100");
    }

    @Test
    public void left_end_slider(){
        WebElement slider = driver.findElement(By.id("slider"));
        WebElement volume = driver.findElement(By.id("value"));

        while(Integer.parseInt(volume.getText())>0) {
            actions.moveToElement(slider).click(slider).sendKeys(Keys.ARROW_DOWN).perform();
        }
        System.out.println("Left end Value in slider : " + volume.getText() + "%");
        Assert.assertEquals(volume.getText(),"0");
    }

    @Test
    public void slider_30(){
        WebElement slider = driver.findElement(By.id("slider"));
        WebElement volume = driver.findElement(By.id("value"));

        while(Integer.parseInt(volume.getText())<30) {
            actions.moveToElement(slider).click(slider).sendKeys(Keys.ARROW_UP).perform();
        }
        System.out.println("Value at the 30% mark of the slider : " + volume.getText());
        Assert.assertEquals(volume.getText(),"30");
    }

    @Test
    public void slider_80(){
        WebElement slider = driver.findElement(By.id("slider"));
        WebElement volume = driver.findElement(By.id("value"));

        while(Integer.parseInt(volume.getText())<80) {
            actions.moveToElement(slider).click(slider).sendKeys(Keys.ARROW_UP).perform();
        }
        System.out.println("Value at the 80% mark of the slider : " + volume.getText());
        Assert.assertEquals(volume.getText(),"80");
    }

    @AfterClass
    public void end(){
        driver.close();
    }
}
