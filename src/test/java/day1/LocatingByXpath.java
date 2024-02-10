package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LocatingByXpath {



    // Basic Xpath syntax

    //    //elementName[@attribute='value']
    //    //input[@aria-label='Google Search']


    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = null;
        try {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");

            driver.findElement(By.xpath("//input[@id='gbqfbb']")).click();
            Thread.sleep(1000);




        }finally {
            driver.quit();
        }

    }
}
