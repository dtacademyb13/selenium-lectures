package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandlingIframes2 {

    //div[@id='cbb']

    @Test
    public void testJSAlert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium

        driver.get("https://www.duotech.io/enroll-sqae2");


        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[starts-with( @id, '1708')]")));

        driver.findElement(By.xpath("//input[@placeholder='First']")).sendKeys("Hello");

        // Interact again with the main window
        // Switch the context to the main window

        driver.switchTo().defaultContent();

        WebElement contacstLink = driver.findElement(By.linkText("Contacts"));

        // Using JS you can click on any element that is invisible or that throws ElementClickInterceptedException or ElementNotInteractableException

        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", contacstLink );






    }

}
