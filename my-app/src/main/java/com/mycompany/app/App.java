package com.mycompany.app;

import java.io.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
//    InputStream is = getClass().getResourceAsStream( "/greeting.txt" );


    public static void main( String[] args )
    {


        System.out.println("Sum res = " + Calculator.sum(5, 6));

        InputStream inStream = App.class.getResourceAsStream("/greeting.txt" );

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;

        try {
            br = new BufferedReader(new InputStreamReader(inStream));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        sb.toString();
        System.out.println(sb);


    }
}
