package com.cybertek.tests.day7_testgn;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title", "tiTle");

        System.out.println("Second Assertion");
        Assert.assertEquals(1,1);
    }

    @Test
    public void test2(){
        System.out.println("Second test case");
        Assert.assertEquals("url", "url");
    }
    @Test
    public void test3(){
        String expectedTitle = "Cybt";
        String actualTitle = "Cybertek";
        //verify that your title is starting with Cyb

        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "Verify title start with Cyb");
        Assert.assertTrue(1>1,"i am checking is 2 greater than 1");

    }
    @Test
    public void test4(){
        //verify that email contain @
        String email = "mikesmith.com";
        Assert.assertTrue(email.contains("@"), "Verify email has @ sign");
    }

    @Test
    public void test5(){
        //Verify something is false
        Assert.assertFalse(0>1, "Verify that is 0 is NOT greater than 1");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one", "two");
    }


}
