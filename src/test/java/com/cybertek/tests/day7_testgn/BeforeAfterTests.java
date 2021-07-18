package com.cybertek.tests.day7_testgn;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BeforeAfterTests {

    @Test
    public void test1(){
        //WebDriver part

        System.out.println("This is my test 1");

        //close browser,quit
    }

    @BeforeMethod
    public void setUp(){
       // WebDriver driver = WebDriverFactory.getDriver("chrome");
        System.out.println("BEFORE METHOD HERE");
        System.out.println("WebDriver part");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("AFTER METHOD HERE");
        System.out.println("Driver quit");
    }

    @Ignore
    @Test
    public void test2(){
        System.out.println("This is my test 2");
    }

    @Test
    public void test3(){
        System.out.println("This is my test 3");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("--BEFORE CLASS--");
        System.out.println("RUNS ONLY ONE IN THE CLASS");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("--AfTER CLASS--");
        System.out.println("RUNS ONLY ONE IN THE CLASS");
        System.out.println("GENERATE REPORT");
    }

}
