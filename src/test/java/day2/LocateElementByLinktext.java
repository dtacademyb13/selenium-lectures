package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocateElementByLinktext {


    @Test
    public void testCase(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.webstaurantstore.com/");

//        driver.findElement(By.linkText("Restaurant Equipment")).click();
        driver.findElement(By.partialLinkText("FREE Shipping")).click();

//        Assert.assertTrue(driver.getTitle().contains("Commercial Restaurant Equipment"));
        Assert.assertTrue(driver.getTitle().contains("WebstaurantPlus"));
    }
}
