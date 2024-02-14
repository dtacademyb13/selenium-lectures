package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class XpathDemo2 {




    @Test
    public void test() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium

        driver.get("https://www.webstaurantstore.com/");

        System.out.println(driver.findElement(By.xpath("//button[@type='submit'][@value='Search']")));


        // using multiple attributes
         //button[@type='submit'][@value='Search']
         //button[@type='submit' and @value='Search']

        // using attribute names only

        //button[@type] -> all button elements with type attribute

        //*[@id] -> any element with an id attribute

        //*[@*] -> any element with any attribute

        //* -> any element

        // text based match


        //div[.='Prep & Transport Racks'] -> div with a text 'Prep & Transport Racks'
        //div[text()='Prep & Transport Racks'] -> div with a text 'Prep & Transport Racks'


        //div[contains( text(), 'Quick Transportation')]

        System.out.println(driver.findElement(By.xpath("//div[contains( text(), 'Quick Transportation')]")).getText());

        // Predicate
        // (xpathExpression)[number]
        //  (//div[@class='somevalue'])[2] -> matches the second of the possible matches




//






    }
}
