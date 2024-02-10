package day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {



    @Test
    public void testCalculator1(){
         Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(10,4), 2.5);
    }

    @Test
    public void testCalculator2(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(4,4), 1.0);
    }

    @Test
    public void testCalculator0(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(0,0), Double.NaN);
    }
}
