package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FindelementVselements {


    @Test
    public void test(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.webstaurantstore.com/");

        // findelement method throws NoSuchElementException if the element is not found
        // findelements method returns an empty list

//        driver.findElement(By.id("searchval")).sendKeys(Keys.chord(Keys.SHIFT, "table"), Keys.ENTER );
        List<WebElement> list = driver.findElements(By.id("searchVal"));
        if(list.isEmpty()){
            throw new RuntimeException("The list is empty. Check your locator.");
        }
        for (WebElement webElement : list) {
            Assert.assertTrue(webElement.getText().contains("dcsd"));
        }


    }
}
