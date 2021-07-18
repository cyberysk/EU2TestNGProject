package com.cybertek.tests.day11_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");
        //locating choosefile button
        WebElement chooseFile = driver.findElement(By.name("file"));
        //sending file
        chooseFile.sendKeys("/Users/ysk/Desktop/file.txt");
        //click upload button
        driver.findElement(By.id("file-submit")).click();
        //verify uploaded file name as expected
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "file.txt");

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/upload");

        WebElement chooseFile = driver.findElement(By.name("file"));
        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testfile.txt";
        String filePath = projectPath + "/" + relativePath;
        chooseFile.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();

        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "testfile.txt");

      //  System.out.println("System.getProperty(\"OS.name\") = " + System.getProperty("os.name"));
    }

}
