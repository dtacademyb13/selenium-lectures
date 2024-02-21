package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class PopUpHandling {



    @Test
    public void testJSAlert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium

        driver.get("https://www.volvo.com/en/");
        Thread.sleep(2000);

        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Menu")).click();

    }
}
