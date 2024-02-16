package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicElements {


    @Test
    public void testCase(){




        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium

        driver.get(" https://www.carfax.com/");


        // To work with dynamic elements, we need to see an attrribute value that stays static and use the corrresponding methods


        // XPATH:
        //input[starts-with(@name, 'name')]
        //input[ends-with(@id, '_username')]
        //input[contains(@id, 'psswd')]

//        CSS:

    // starts-with ->    input[name^='name']
    // ends-with ->    input[name$='name']
    // contains ->    input[name*='name']


        driver.findElement(By.xpath("//input[starts-with(@name, 'name')]")).sendKeys("John Doe");

    }
}
