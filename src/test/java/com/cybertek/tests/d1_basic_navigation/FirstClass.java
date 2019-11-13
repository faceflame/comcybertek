package com.cybertek.tests.d1_basic_navigation;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class FirstClass {
    public static void main(String[] args) {



        System.out.println("What a");
        Faker faker = new Faker();

        System.out.println(faker.name().fullName());
        System.out.println(faker.chuckNorris().fact());
            }
}
