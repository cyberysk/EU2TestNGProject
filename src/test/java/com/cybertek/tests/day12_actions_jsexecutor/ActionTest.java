package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ActionTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void hoverTest(){

        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1 = driver.findElement(By.tagName("img"));
        //Actions--> class that contains all the user interactions
        //how to create action object / passing driver as a constructor
        Actions actions = new Actions(driver);
        //perform()--> perform the action, complete action
        //moveTo Element()--> move your mouse to web element (hover over)
        actions.moveToElement(img1).perform();

        WebElement link = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(link.isDisplayed(), "Verify View profile lnk is displayed");

        WebElement img2 = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[2]"));

        actions.moveToElement(img2).perform();

        link = driver.findElement(By.linkText("View profile"));

        Assert.assertTrue(link.isDisplayed());

    }

    @Test
    public void DragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[.='Accept and Close']")).click();

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        Thread.sleep(2000);
        actions.dragAndDrop(source, target).perform();



    }
    @Test
    public void DragAndDropChaining() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[.='Accept and Close']")).click();
        Thread.sleep(2000);
        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));

        //drag and drop without dragAndDrop method (by manually/chaining)

        //if you are chaining action we are adding build() method before perform().
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().build().perform();


    }

}
