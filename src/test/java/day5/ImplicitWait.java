package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWait {



    @Test
    public void testJSExecutor() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //implicit wait is a dynamic wait provided by Selenium

        driver.get("https://www.instagram.com/");


        driver.findElement(By.name("username")).sendKeys("cdsvd");
        driver.findElement(By.name("password")).sendKeys("cdcdsbcvssvd", Keys.ENTER);


        //Thread.sleep();
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='_ab2z']"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }
    }
