package com.cybertek.tests.d10_Frames;

import com.cybertek.utilities.WebDriverFactory;
import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClass {

    private WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/hovers");
    }

    @Test
    public void test1(){



    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
