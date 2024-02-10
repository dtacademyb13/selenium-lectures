package day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumBasics {


    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.selenium.dev/");
        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();

        System.out.println(currentUrl);
        System.out.println(title);

        System.out.println(driver.getPageSource());

        if(driver.getPageSource().contains("Selenium automates browsers. That's it!")){
            System.out.println("Test Passed.");
        }else{
            System.out.println("Test failed");
        }

//
//        driver.quit(); // quits all open tabs and ends the browser session
//        driver.close(); // only closes the currently active tab

        driver.navigate().to("https://www.duotech.io/");
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
        Thread.sleep(1000);
        driver.navigate().refresh();









    }

}
