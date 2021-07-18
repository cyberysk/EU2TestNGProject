package com.cybertek.tests.yskWorks.TstCases;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCase1to5 {

    WebDriver driver = WebDriverFactory.getDriver("chrome");

    @BeforeMethod
    public void setUp() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("https://practice-cybertekschool.herokuapp.com");
        WebElement registrationForm = driver.findElement(By.partialLinkText("Registration Form"));
        registrationForm.click();
        Thread.sleep(3000);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test1(){

        WebElement dateOfBirth = driver.findElement(By.name("birthday"));
        dateOfBirth.sendKeys("22/11/2000");
        String expectedResult = "The date of birth is not valid";
        Assert.assertEquals(driver.findElements(By.xpath("//small[contains(text(),'not valid')]")),expectedResult, "Verify NOT VALID message");

    }
    @Test
    public void test2(){

        ArrayList<String> expectedList = new ArrayList<String>();
            expectedList.add("C++");
            expectedList.add("Java");
            expectedList.add("JavaScript");

        ArrayList<String> actualList = new ArrayList<>();
            actualList.add(driver.findElement(By.xpath("//label[@for='inlineCheckbox1']")).getText());
            actualList.add(driver.findElement(By.xpath("//label[@for='inlineCheckbox2']")).getText());
            actualList.add(driver.findElement(By.xpath("//label[@for='inlineCheckbox3']")).getText());

            Assert.assertEquals(actualList,expectedList);

    }

    @Test
    public void test3() throws InterruptedException {
        WebElement nameInputBox= driver.findElement(By.name("firstname"));
        nameInputBox.sendKeys("a");
        Thread.sleep(2000);
        String expected = "first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(driver.findElement(By.xpath("//small[contains(text(),'first name must')]")).getText(),expected);

    }

    @Test
    public void test4() throws InterruptedException {
        WebElement lastNameInputBox= driver.findElement(By.name("lastname"));
        lastNameInputBox.sendKeys("b");
        Thread.sleep(2000);
        String expected = "The last name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(driver.findElement(By.xpath("//small[contains(text(),'The last name must')]")).getText(),expected);

    }

    @Test
    public void test5() throws InterruptedException {
//        WebElement nameInputBox = driver.findElement(By.name("firstname"));
//        nameInputBox.sendKeys("Ahmet");
        driver.findElement(By.name("firstname")).sendKeys("Ahmet");
        driver.findElement(By.name("lastname")).sendKeys("Sezgin");
        driver.findElement(By.name("username")).sendKeys("askask");
        driver.findElement(By.name("email")).sendKeys("ask@askmail.com");
        driver.findElement(By.name("password")).sendKeys("askaskask");
        driver.findElement(By.name("phone")).sendKeys("555-666-7777");
        driver.findElement(By.xpath("//input[@value='male']")).click();
        driver.findElement(By.name("birthday")).sendKeys("11/11/2011");

        WebElement dropdownElement = driver.findElement(By.name("department"));
        Select dropdownDepartment = new Select(dropdownElement);

        dropdownDepartment.selectByVisibleText("Department of Engineering");

        dropdownElement = driver.findElement(By.name("job_title"));

        Select dropdownJobTitle = new Select(dropdownElement);
        dropdownJobTitle.selectByVisibleText("Developer");

        driver.findElement(By.xpath("//label[@for='inlineCheckbox2']")).click();
        Thread.sleep(10000);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(3000);

        String expectedMessage = "You've successfully completed registration!";

        String actualMessage = driver.findElement(By.cssSelector("div[role='alert']>p")).getText();

        Assert.assertEquals(actualMessage,expectedMessage);


    }
}


