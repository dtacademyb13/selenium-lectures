package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SendKeys {


    @Test
    public void test(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.webstaurantstore.com/");



        driver.findElement(By.id("searchval")).sendKeys(Keys.chord(Keys.SHIFT, "table"));
        driver.findElement(By.id("searchval")).sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE);



    }
}
