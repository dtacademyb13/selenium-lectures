package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandlingIframes {

    //div[@id='cbb']

    @Test
    public void testJSAlert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium

        driver.get("https://demoqa.com/");

        Thread.sleep(3000);

        driver.switchTo().frame(0);

        driver.findElement(By.xpath("//div[@id='cbb']")).click();

        //input[@placeholder='First']

    }

}
