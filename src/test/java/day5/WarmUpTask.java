package day5;

import day2.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class WarmUpTask {



    @Test
    public void testJSAlert() throws InterruptedException {
        WebDriver driver = null;
       try {
           driver = new ChromeDriver();
           driver.manage().deleteAllCookies();
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium

           // End-to-end test

           driver.get("https://www.hoteltonight.com/");



           driver.findElement(By.xpath("//div[.='Tonight'][not(@class)]")).click();

           driver.findElement(By.xpath("//span[@class='_vao1kgk']//span[.='10'][@class='_os6tbd']")).click();
           driver.findElement(By.xpath("//span[@class='_vao1kgk']//span[.='16'][@class='_os6tbd']")).click();
           driver.findElement(By.xpath("//button[.='Done']")).click();
           driver.findElement(By.xpath("//button[.='Go']")).click();

           List<WebElement> elements = driver.findElements(By.xpath("//div[@data-aid='inventory-item-rate']/span/span"));

           List<String> elementsText = SeleniumUtils.getElementsText(elements);

           System.out.println(elementsText);

           List<Integer> list = new ArrayList<>();

           elementsText.forEach( s -> list.add(Integer.valueOf(s.replace("$", ""))));

           list.sort(Comparator.reverseOrder());

           System.out.println("Sorted list: " + list);


           List<WebElement> links = driver.findElements(By.xpath("//h3[@data-aid='inventory-item-name']"));

           WebElement lastResult = links.get(links.size() - 1);

           String expectedTitle = lastResult.getText();


           new Actions(driver).keyDown(Keys.COMMAND).click(lastResult).perform();

           //Switch to a new window

//           String currentHandle = driver.getWindowHandle();
//           Set<String> windowHandles = driver.getWindowHandles();
//
//           for (String windowHandle : windowHandles) {
//               if(!windowHandle.equals(currentHandle)){
//                   driver.switchTo().window(windowHandle);
//               }
//           }

           SeleniumUtils.switchToWindow(driver);


           String actualTitle = driver.findElement(By.xpath("//h1[@data-aid='hotel-name']")).getText();

           Assert.assertEquals(actualTitle, expectedTitle);


       }finally {
           Thread.sleep(5000);
           driver.quit();
       }



    }
}
