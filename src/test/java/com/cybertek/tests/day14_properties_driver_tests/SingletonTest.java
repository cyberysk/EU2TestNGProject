package com.cybertek.tests.day14_properties_driver_tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test(){
      //  Singleton s1 = new Singleton();//error because private constructor
        // we can not create object from this class

        String s1 = Singleton.getInstance();
        String s2 = Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
    @Test
    public void test1() throws InterruptedException {

       // WebDriver driver = Driver.get();
      //  driver.get("https://www.google.com");

        Driver.get().get("https://www.google.com");
        Thread.sleep(2000);
       // Driver.closeDriver();
    }

    @Test
    public void test2(){
       // WebDriver driver = Driver.get();
       // driver.get("https://www.amazon.com");
        Driver.get().get("https://www.amazon.com");

        //this is open the url that is in the configuration files
       // Driver.get().get(ConfigurationReader.get("url"));

    }
}
