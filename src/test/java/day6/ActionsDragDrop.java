package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsDragDrop {


    @Test
    public void testJSExecutor() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://javascript.info/mouse-drag-and-drop");


        //

//        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/article/mouse-drag-and-drop/ball4/']")));
//
//
//        WebElement source = driver.findElement(By.id("ball"));
//
//        WebElement target = driver.findElement(By.id("gate"));
//
//        new Actions(driver).dragAndDrop(source, target).perform();

          driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://en.js.cx/article/mouse-drag-and-drop/ball3/']")));
//
        WebElement source = driver.findElement(By.id("ball"));

//        new Actions(driver).dragAndDropBy(source, 500, 100).perform();

        new Actions(driver).clickAndHold(source).moveByOffset(500, 100).release(source).perform();






    }
}
