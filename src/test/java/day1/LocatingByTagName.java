package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LocatingByTagName {

    @Test
    public void test1(){

        WebDriver driver = null;
        try {

            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
            driver.findElement(By.name("q")).sendKeys("dragon", Keys.ENTER);

            // Locate the first link on the page
            WebElement theFirstLinkOnthePage = driver.findElement(By.tagName("a"));
            // Locate all the links on the page
            List<WebElement> links = driver.findElements(By.tagName("a"));

            for (WebElement link : links) {
                System.out.println(link.getText());
            }


        }finally {
            driver.quit();
        }

    }
}
