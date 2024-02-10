package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WaitDemo {


    @Test
    public void test1() throws InterruptedException {

        WebDriver driver = null;
        try {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.instagram.com/");

            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@aria-label='Phone number, username, or email']")).sendKeys("invalidUser");
            driver.findElement(By.name("password")).sendKeys("invalidPass");
            driver.findElement(By.xpath("//button[@class=' _acan _acap _acas _aj1- _ap30']")).click();



        }finally {
            driver.quit();
        }

    }
}
