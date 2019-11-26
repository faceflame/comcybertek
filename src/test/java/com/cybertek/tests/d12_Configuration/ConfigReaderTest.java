package com.cybertek.tests.d12_Configuration;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfigReaderTest {

    @Test
    public void test1(){

        String expectedBrowser = "chrome";
        String actualBrowser=ConfigurationReader.get("browser");
        System.out.println(actualBrowser);
        Assert.assertEquals(expectedBrowser, actualBrowser);
        String actualURl=ConfigurationReader.get("url");
        System.out.println(actualURl);
        String actualUsername= ConfigurationReader.get("user_name");
        System.out.println(actualUsername);
        String actualPassword= ConfigurationReader.get("password");
        System.out.println(actualPassword);
    }

}
