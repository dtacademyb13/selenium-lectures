package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumUtils {



    public static WebElement locateByDataTestIdSingle(WebDriver driver, String elementName, String datatestid){
        return driver.findElement(By.xpath("//" + elementName + "[@data-testid='"+datatestid+"']"));
    }
    public static List<WebElement> locateByDataTestIdMultiple(WebDriver driver, String elementName, String datatestid){
        return driver.findElements(By.xpath("//" + elementName + "[@data-testid='"+datatestid+"']"));
    }
}
