package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iFrames {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");
       // driver.findElement(By.id("tinymce")).sendKeys("Ahmet Sezgin");

        //how to switch frames
        //1.Switch by using name or id attribute of frame
        driver.switchTo().frame("mce_0_ifr");

        //clear before send keys
        driver.findElement(By.id("tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("tinymce")).sendKeys("Ahmet Sezgin");

        //switch back to main frame
        //goes back to first frame, useful when we have switched multiple frames
        driver.switchTo().defaultContent();
        Thread.sleep(1000);

        //2.USING INDEX
        driver.switchTo().frame(0);
        //clear before send keys
        driver.findElement(By.id("tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("tinymce")).sendKeys("Ahmet Sezgin USING INDEX");

        //second way to switch parent
        driver.switchTo().parentFrame();

        //3.USING WEB ELEMENT
        //locating iframe with any valid locator
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);
        //clear before send keys
        driver.findElement(By.id("tinymce")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("tinymce")).sendKeys("Ahmet Sezgin WEB ELEMENT");

    }

    @Test
    public void test2(){

        driver.get("http://practice.cybertekschool.com/nested_frames");

        //switching to frame top
        driver.switchTo().frame("frame-top");

        //top has 3 children left-middle-right
        //switching to frame middle
        driver.switchTo().frame("frame-middle");

        System.out.println(driver.findElement(By.id("content")).getText());

        //switching to parent (one up parents) that is frame top
        driver.switchTo().parentFrame();

        //switching to right frame with index using
        driver.switchTo().frame(2);
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //switching to main HTML we for that we can use default content
        driver.switchTo().defaultContent();

        //switching to bottom frame
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.tagName("body")).getText());
    }
}
