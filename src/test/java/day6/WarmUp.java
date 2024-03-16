package day6;

import day2.SeleniumUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WarmUp {


    //My change - Bob

    @Test
    public void testJSExecutor() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.dice.com/");

        driver.findElement(By.id("typeaheadInput")).sendKeys("SDET");
        driver.findElement(By.id("IPGeoLocateButton")).click();

        //Thread.sleep(3000);

//        WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(7));
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[@class='card-title-link normal']")));


        SeleniumUtils.waitForPresenceOfAllElements(driver, Duration.ofSeconds(7), By.xpath("//a[@class='card-title-link normal']"));

        // The default polling frequency for Implicit and Explicit wait is 500ms


        // Fluent Wait

//        Wait fluentWait = new FluentWait<>(driver)
//                .pollingEvery(Duration.ofMillis(2000))
//                .ignoring(NoSuchElementException.class)
//                .ignoring(StaleElementReferenceException.class);
//
//        fluentWait.until(ExpectedConditions.elementToBeClickable(By.id("someElement")));




        List<WebElement> titles = driver.findElements(By.xpath("//a[@class='card-title-link normal']"));

        if(titles.isEmpty()){
            throw new RuntimeException("the list is empty");
        }

        for (WebElement title : titles) {
            System.out.println(title.getText());
        }


        //

        WebElement firstresult = titles.get(0);
        firstresult.click();


        driver.navigate().back();

        driver.navigate().forward();

//        SeleniumUtils.waitForPresenceOfAllElements(driver, Duration.ofSeconds(7), By.xpath("//a[@class='card-title-link normal']"));


        //When you store an element and then navigate away from the page or elements on the page are re-loaded
        // The easiest fix is to re-locate the element and then interact



//        firstresult.click(); // StaleElementReferenceException: stale element reference: stale element not found

        SeleniumUtils.waitForPresenceOfAllElements(driver, Duration.ofSeconds(7), By.xpath("//a[@class='card-title-link normal']"));


        titles = driver.findElements(By.xpath("//a[@class='card-title-link normal']"));
        for (WebElement title : titles) {

        }

        titles.get(0).click();


        // Another way of fixing the StaleElement Exception is to refresh the page and obtain the fresh reference to an element of list of elements



    }
}
