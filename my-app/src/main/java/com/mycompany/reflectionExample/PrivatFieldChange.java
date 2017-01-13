package com.mycompany.reflectionExample;
import java.lang.reflect.Field;
/**
 * Created by Daria Serebryakova on 13.01.2017.
 */



class WithPrivateFinalField {
    private int i = 1;
    private final String s1 = "String S1"; //FINAL
    private String s2 = "String S2";

    public String toString() {
        return "i = " + i + ", " + s1 + ", " + s2;
    }
}
public class PrivatFieldChange {

    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);

        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        f.setInt(pf, 47);
        System.out.println(pf);

        f = pf.getClass().getDeclaredField("s1");//FINAL
        f.setAccessible(true);
        f.set(pf, "MODIFY S1");
        System.out.println(pf);


        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        f.set(pf, "MODIFY S2");
        System.out.println(pf);
    }
}
