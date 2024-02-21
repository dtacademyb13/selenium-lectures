package day4;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class JSAlertsPrompt {




    @Test
    public void testJSAlert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();



        Alert alert = driver.switchTo().alert();

        // Verify the text

        System.out.println("The text of the alert: " + alert.getText());

        alert.sendKeys("Testing");

        alert.accept();

        Thread.sleep(2000);

        driver.findElement(By.linkText("Elemental Selenium")).click();

    }

}
