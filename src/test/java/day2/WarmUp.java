package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WarmUp {


    @Test
    public void testCase(){
        // 1. Got to the https://www.webstaurantstore.com/

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.webstaurantstore.com/");

        // 2. Search for a product (table)

        String term =  "table";
        driver.findElement(By.id("searchval")).sendKeys(term, Keys.ENTER);

        // 3. Verify the default results per page is 60

    // List<WebElement> titles =   driver.findElements(By.xpath("//span[@data-testid='itemDescription']"));

        List<WebElement> titles = SeleniumUtils.locateByDataTestIdMultiple(driver, "span", "itemDescription");

        Assert.assertEquals(titles.size(), 60);

        //  //elementName[@attr='value']

        // 4. Verify the product titles contain the search term

        for (WebElement webElement: titles){

            Assert.assertTrue(webElement.getText().toLowerCase().contains(term));
        }

        // 5. Click on the last title and verify the title text matches
        WebElement lastOne = titles.get(titles.size() - 1);

        String expected = lastOne.getText();
        lastOne.click();

        String actual = driver.findElement(By.id("page-header-description")).getText();

        Assert.assertEquals(actual, expected);


    }
}
