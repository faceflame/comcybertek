package com.cybertek.tests.PracticesByVAsya;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase1 {

    public static void main(String[] args) {

        String expectedSignUpMessage="Thank you for signing up. Click the button below to return to the home page.";

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://practice.cybertekschool.com/");

        WebElement SignUpForMailingList= driver.findElement(By.xpath("/html/body/div/div[2]/div/ul/li[43]/a"));
        SignUpForMailingList.click();

        WebElement FullNameBox=driver.findElement(By.name("full_name"));
        FullNameBox.sendKeys("JucK Norris");

        WebElement EmailBox=driver.findElement(By.name("email"));
        EmailBox.sendKeys("ala@gmail.com");

        WebElement SignUpButton = driver.findElement(By.name("wooden_spoon"));
        SignUpButton.click();

        WebElement SignUpMessage=driver.findElement(By.name("signup_message"));
        String actualSignUpMessage= SignUpMessage.getText();

if (actualSignUpMessage.equals(expectedSignUpMessage)){
    System.out.println("PASS");
}

else{
    System.out.println("Fail");
    System.out.println("Expected Signup Message: " + expectedSignUpMessage);
    System.out.println("Actual Signup Message " + actualSignUpMessage);
}


driver.quit();

    }
}
