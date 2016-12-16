package com.mycompany.app;
import org.junit.*;

import java.io.InputStream;

/**
 * Unit test for simple CalculatorTest.
 * Created by Daria Serebryakova on 08.12.2016.
 */
public class CalculatorTest {
//    Calculator calc = new Calculator();
    InputStream is = getClass().getResourceAsStream( "/test.properties" );

    @Test
    public void testSumOperation(){
        assert(5 == Calculator.sum(5,0)): "sum works incorrect";

    }
    public void testDiv1Operation(){
        assert(1 == Calculator.div(5,5)): "div works incorrect";

    }
    public void testDiv2Operation(){

        assert(10 == Calculator.div(5,5)): "div works incorrect";
    }
    public void testDivZeroOperation(){
        assert(10 == Calculator.div(5,0)): "div works incorrect - zero";

    }


}
