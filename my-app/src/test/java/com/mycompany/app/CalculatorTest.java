package com.mycompany.app;

import junit.framework.TestCase;
//import org.testng.annotations.Test;

import org.junit.*;
//import junit.framework.Test;
//import junit.framework.TestSuite;
//import static org.junit.Assert.*;

/**
 * Unit test for simple CalculatorTest.
 * Created by Daria Serebryakova on 08.12.2016.
 */
public class CalculatorTest extends  TestCase{
//    Calculator calc = new Calculator();

    @Test
    public void testSumOperation(){
//        assert(5 == Calculator.sum(5,0)): "sum works incorrect";
        assertEquals("5+5=10",10,Calculator.sum(5,5));
    }
    public void testDiv1Operation(){
        assert(1 == Calculator.div(5,5)): "div works incorrect";

    }
    public void testDiv2Operation(){

//        assert(10 == Calculator.div(5,5)): "div works incorrect";
    }
    public void testDivZeroOperation(){
//        assert(10 == Calculator.div(5,0)): "div works incorrect - zero";

    }


}
