package day4;

import day2.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HandlingWebtables2 {


    @Test
    public void testWebtables(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait is a dynamic wait provided by Selenium

        driver.get("https://www.livecoinwatch.com/");

        int columns = driver.findElements(By.xpath("//caption[.='Live Crypto Prices']//parent::table//thead//tr//th")).size();

        int rows = driver.findElements(By.xpath("//caption[.='Live Crypto Prices']//parent::table//tbody//tr[@class='table-row filter-row']")).size();



        //ITERATE THROUGH THE TABLE CONTENT

        //c
//        for (int i = 1; i <=rows ; i++) {
//
//            for (int j = 1; j <=columns ; j++) {
//
//                String xpath = "//caption[.='Live Crypto Prices']//parent::table//tbody//tr[@class='table-row filter-row'][" + i + "]//td[" + j + "]";
//
//                String eachCellsText = driver.findElement(By.xpath(xpath)).getText().trim();
//
//                System.out.println(xpath);
////                System.out.print(eachCellsText + "\t");
//
//            }
//
////            System.out.println();
//        }


        // Grab 8th row and 2nd column's text

        System.out.println(getCellText(8 , 2, driver));

        System.out.println(getColumnsText(2, driver));

        System.out.println(getRowsText(2, driver));

        // CLICK ON 1h column and verify the descending order of the column data


        driver.findElement(By.xpath("(//span[.='1h'])[1]")).click();

        ///driver.navigate().refresh();

        List<String> columnsText = getColumnsText(8, driver);



        System.out.println(columnsText);

        List<Double> prices =  new ArrayList<>();



        for (String price : columnsText) {
          prices.add(Double.parseDouble(price.replace("%", "")));
        }

        List<Double> pricesCopy =  new ArrayList<>(prices);

        pricesCopy.sort(Comparator.reverseOrder());

        System.out.println("Original: " + prices);
        System.out.println("Copy: " + pricesCopy);

        Assert.assertEquals(pricesCopy, prices);



        // Verify the sorting order of a collection




    }


    public static String getCellText(int row, int column, WebDriver driver){

        String xpath = "//caption[.='Live Crypto Prices']//parent::table//tbody//tr[@class='table-row filter-row'][" + row + "]//td[" + column + "]";

        return driver.findElement(By.xpath(xpath)).getText();

    }



    public static List<String> getColumnsText(int column, WebDriver driver){

        String xpath = "//caption[.='Live Crypto Prices']//parent::table//tbody//tr[@class='table-row filter-row']//td["+column+"]";

        return SeleniumUtils.getElementsText(driver.findElements(By.xpath(xpath)));
    }

    public static List<String> getRowsText(int row, WebDriver driver){

        String xpath = "//caption[.='Live Crypto Prices']//parent::table//tbody//tr[@class='table-row filter-row']["+row+"]//td";

        return SeleniumUtils.getElementsText(driver.findElements(By.xpath(xpath)));
    }
}
