package com.cybertek.tests.d12_Configuration;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Ignore
    @Test
    public void test1() throws InterruptedException {
        String url= ConfigurationReader.get("url");

        //Driver.get() will return webdriver objet
        //and then we can call webdriver methods like get(), findElement()...
        Driver.get().get(url);
        System.out.println(Driver.get().getTitle());
        Thread.sleep(2000);
        Driver.close();

    }

    @Test
    public void test2() throws InterruptedException {
        System.out.println(Driver.get().getTitle());
        Thread.sleep(2000);


    }


}
