package day3;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WarmUp {


    @Test
    public void testSignUp() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium

        driver.get("http://qa-duobank.us-east-2.elasticbeanstalk.com/register.php");

        Faker faker = new Faker();
        String first = faker.address().firstName();
        String last = faker.address().lastName();
        String email = faker.internet().emailAddress();
        driver.findElement(By.xpath("//input[@placeholder='First name']")).sendKeys(
                first, Keys.TAB,
                last, Keys.TAB,
                email, Keys.TAB,
                 "Hello4World&", Keys.ENTER );

        Thread.sleep(1000);

        Assert.assertTrue(driver.getPageSource().contains("Registration Successfull"));






    }
}
