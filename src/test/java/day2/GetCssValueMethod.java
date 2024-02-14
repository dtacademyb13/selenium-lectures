package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetCssValueMethod {

    @Test
    public void test(){


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.webstaurantstore.com/");

        WebElement element = driver.findElement(By.xpath("//button[@value='Search']"));

        String expectedColorCode = "rgba(255, 255, 255, 1)";

        System.out.println(element.getCssValue("color"));
        System.out.println(element.getCssValue("font-family"));

        Assert.assertEquals(element.getCssValue("color"), expectedColorCode);

        // Get location and size of an element

        System.out.println(driver.findElement(By.xpath("//a[@data-testid='logo']")).getLocation());
        System.out.println(driver.findElement(By.xpath("//a[@data-testid='logo']")).getSize());

        WebElement webElement = driver.findElement(By.xpath("//a[@data-testid='logo']"));

        System.out.println(webElement.getTagName());

        // Locate all elements on the page and see their tags
        List<WebElement> allElements = driver.findElements(By.xpath("//*"));

        for (WebElement allElement : allElements) {
            System.out.println(allElement.getTagName());
        }


    }
}
