package day6;

import day2.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsDemo {


    @Test
    public void testJSExecutor() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.dice.com/");


        WebElement searchbar = driver.findElement(By.id("typeaheadInput"));

        Actions actions = new Actions(driver);

        actions.keyDown(Keys.SHIFT).sendKeys(searchbar, "sdet").keyUp(Keys.SHIFT).sendKeys(searchbar, " qa").perform();

       actions.keyDown(Keys.LEFT_SHIFT).click(driver.findElement(By.linkText("Project Manager"))).build().perform();


    }
}
