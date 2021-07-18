package com.cybertek.tests.day14_properties_driver_tests;

public class Singleton {

    //private constructor; by this way prohibited object creation
    //Singleton class will have private constructor
    //it means other classes can not create object of this class
    private Singleton() {

    }

    private static String str;


    public static String getInstance() {
        //if str has no value, initialize it and return it

        if (str == null) {
            System.out.println("str is null. assigning value to it");
            str = "somevalue";
        } else {
            //if it has value just return it
            System.out.println("it has value just return it");
        }
        return str;
    }
}