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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverTest {
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

        List<WebElement> imgElements = driver.findElements(By.xpath("//img"));

        Actions actions = new Actions(driver);

        for (int i = 1; i <= imgElements.size(); i++) {

            String expectedText = "name: user"+i;
            WebElement imgElement = driver.findElement(By.xpath("(//img)["+i+"]" ));
            actions.moveToElement(imgElement).pause(250).perform();
            String actualText = driver.findElement(By.xpath("(//h5)[" +i+"]")).getText();
            System.out.println("expectedText " +i+ " = " + expectedText);
            System.out.println("actualText " +i+ " = " +  actualText);
            Assert.assertTrue(imgElement.isDisplayed());
            Assert.assertEquals(actualText,expectedText,  "Verify text of image"+i );
        }


//        for (WebElement imgElement : imgElements) {
//            String expectedText = "User"+i;
//            String actualText = imgElement.getText()+i;
//            System.out.println("actualText = " + actualText);
//            System.out.println("expectedText = " + expectedText);
//            Assert.assertEquals(actualText,expectedText,  "Verify text of image"+i );
//            i++;
//        }

    }
}
