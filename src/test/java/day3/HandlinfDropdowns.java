package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandlinfDropdowns {




    @Test
    public void testCase() {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium

        driver.get(" https://www.carfax.com/");

        driver.findElement(By.linkText("Used Car Values")).click();

        driver.findElement(By.cssSelector("#zip")).sendKeys("22043");
        driver.findElement(By.cssSelector("#plate")).sendKeys("UGA1010");

        WebElement selectElement = driver.findElement(By.cssSelector("#us-state"));

        Select select = new Select(selectElement);

//        select.selectByVisibleText("VA");
//        new Select(driver.findElement(By.cssSelector("#us-state"))).selectByValue("VA");
//        new Select(driver.findElement(By.cssSelector("#us-state"))).selectByIndex(1); // 1 based index
//        new Select(driver.findElement(By.cssSelector("#us-state"))).deselectByValue("AL"); // UnsupportedOperationException: You may only deselect options of a multi-select

        Select dropdownbox = new Select(driver.findElement(By.cssSelector("#us-state")));

        // Verify the default selected option is State
        WebElement firstSelectedOption = dropdownbox.getFirstSelectedOption();

        System.out.println(firstSelectedOption.getText());


        driver.findElement(By.cssSelector("button[class='button ripple-container vehicleInputFormStyle_vehicle-input-form__input__submit__4aiwM']")).click();





    }

}
