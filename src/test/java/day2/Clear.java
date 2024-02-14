package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Clear {


    @Test
    public void test() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.hoteltonight.com/");

         Thread.sleep(2000);

//        driver.findElement(By.name("searchfield")).clear(); // clear does not always work
        driver.findElement(By.name("searchfield")).sendKeys(Keys.chord(Keys.COMMAND, "A"), Keys.BACK_SPACE);
        driver.findElement(By.name("searchfield")).sendKeys("Vienna VA", Keys.ENTER);
//        driver.findElement(By.name("searchfield")).submit();


        driver.findElement(By.xpath("parentId")).findElement(By.id("childId"));





    }
}
