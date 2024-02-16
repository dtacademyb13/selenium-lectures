package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HandlingCheckboxes2 {

    @Test
    public void testCase() {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium

        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");

        driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);


        List<WebElement> elements = driver.findElements(By.cssSelector("input[type='checkbox']"));

        for (WebElement element : elements) {
            element.click();
        }

        driver.findElement(By.cssSelector(".btnDeleteSelected")).click();


        driver.findElement(By.cssSelector("a[href='Process.aspx']")).click();

        driver.findElement(By.cssSelector("input[value='MasterCard']")).click();



//



    }
}
