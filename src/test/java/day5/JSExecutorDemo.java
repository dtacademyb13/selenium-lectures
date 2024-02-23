package day5;

import day2.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSExecutorDemo {

    //span[.='Prime Membership']

    @Test
    public void testJSExecutor() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium

        driver.get("https://www.amazon.com/");
        Thread.sleep(10000);

//       driver.findElement(By.xpath("//span[.='Prime Membership']")).click();
       //ElementNotInteractableException: element not interactable
        //

//        JavascriptExecutor js = (JavascriptExecutor)driver;

        WebElement link = driver.findElement(By.xpath("//span[.='Prime Membership']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , link );
        SeleniumUtils.jsClick(driver, link);

    }
}
