package com.mycompany.app;

/**
 * Created by Daria Serebryakova on 08.12.2016.
 */
public class Calculator {
    public String calcName = "Calculator";
    protected double calcAccurancy = 0.0001;
    private int id = 12943;

    public Calculator(){
        System.out.println( "Calculator created" );
    }
    public Calculator(String str, int n){
        System.out.println( "Calculator created + str" );
    }

    public static int sum(int x, int y){
        return x+y;
    }
    public static int div(int x, int y){
        return x/y;
    }



}
