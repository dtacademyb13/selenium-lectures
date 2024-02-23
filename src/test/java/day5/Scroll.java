package day5;

import day2.SeleniumUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Scroll {

    //span[.='Prime Membership']

    @Test
    public void testJSExecutor() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium




        driver.get("https://www.duotech.io/");

//        WebElement webElement = driver.findElement(By.xpath("//a[.='Enroll Now']"));
//
//        int verticalLocation = webElement.getLocation().getY();
//        System.out.println(verticalLocation);
//        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+verticalLocation+")");
//
//      Thread.sleep(3000);
        SeleniumUtils.scrollToWebElement(driver, driver.findElement(By.xpath("//h2[.='Benefits of becoming SQAE']")));

        Thread.sleep(1000);

    }
}
