package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HandlingDropdowns2 {




    @Test
    public void testCase() throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium

        driver.get("https://www.autotrader.com/");

        Select makeDropdown =  new Select(driver.findElement(By.cssSelector("select[name='makeCode']")));

        Assert.assertEquals(makeDropdown.getFirstSelectedOption().getText(), "Any Make");

        makeDropdown.selectByVisibleText("Rivian");

        Thread.sleep(2000);


        List<String > expectedRivianModels = List.of("Any Model");
        List<WebElement> options = new Select(driver.findElement(By.cssSelector("select[name='ModelCode']"))).getOptions();

        List<String> actualRivianModels = new ArrayList<>();
        for (WebElement option : options) {
            actualRivianModels.add(option.getText());
        }

        Assert.assertEquals(actualRivianModels, expectedRivianModels);




    }

}
