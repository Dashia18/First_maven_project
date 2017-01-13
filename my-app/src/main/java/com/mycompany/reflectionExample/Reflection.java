package com.mycompany.reflectionExample;

import com.mycompany.app.Calculator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;

/**
 * Created by Daria Serebryakova on 13.01.2017.
 */
public class Reflection {
    public static void getClassName() {

        Number n = new Integer(6);
        Class nclass = n.getClass();
        System.out.println("nclass = " + nclass);
        Class class1 = Reflection.class;
        Class class2 = Number.class;
        System.out.println("class1 = " + class1);
        System.out.println("class1 = " + class2);

        try {
            Class class3 = Class.forName("com.mycompany.app.Calculator");
            System.out.println("class3 = " + class3);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String str = class2.getName();
        System.out.println(str);
    }

    public static void getModifiersType() {
        Calculator calc = new Calculator();

        Class c =  calc.getClass();

        int mods = c.getModifiers();

        if (Modifier.isPublic(mods)) {
            System.out.println("public");
        }
        if (Modifier.isAbstract(mods)) {
            System.out.println("abstract");
        }
        if (Modifier.isFinal(mods)) {
            System.out.println("final");
        }
    }

    public static void getSuperClassInf(){
        Calculator calc = new Calculator();

        Class c = calc.getClass();
        Class superclass = c.getSuperclass();
        System.out.println("superclass = " + superclass);
    }

    public static void getInterfacesInf() {
        Class c =  LinkedList.class;
        Class[] interfaces = c.getInterfaces();
        for(Class cInterface : interfaces) {
            System.out.println( cInterface.getName() );
        }
    }

    public static void getFieldInf () {
        Calculator obj = new Calculator();

        Class c = obj.getClass();
        Field[] publicFields = c.getFields();

//        System.out.println("Only public field");
//        for (Field field : publicFields) {
//            Class fieldType = field.getType();
//            System.out.println("Имя: " + field.getName());
//            System.out.println("Тип: " + fieldType.getName());
//        }

        Field[]allFields = c.getDeclaredFields();
        System.out.println("\nAll field");
        for (Field fieldAll : allFields) {
            Class fieldTypeAll = fieldAll.getType();
            System.out.println("Имя: " + fieldAll.getName());
            System.out.println("Тип: " + fieldTypeAll.getName());
        }



        System.out.println("\nModifier Type Name for field");
        try {
            Field nameField = c.getField("calcName");


            System.out.println("nameField = " + nameField);
            try {
                nameField.set(obj, "calcNameNew");
                
                String nameValue = (String) nameField.get(obj);
                System.out.println("nameValue = " + nameValue);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }



    }

    public static void getConstuctorInf (){
        Calculator obj = new Calculator();

        Class c = obj.getClass();
        System.out.print("\nConstructor type parameters");
        Constructor[] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();

            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();
        }
    }

    public static void getMethodInf (){
        Calculator obj = new Calculator();

        Class c = obj.getClass();
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            System.out.println("Имя: " + method.getName());
            System.out.println("Возвращаемый тип: " + method.getReturnType().getName());

            Class[] paramTypes = method.getParameterTypes();
            System.out.print("Типы параметров: ");
            for (Class paramType : paramTypes) {
                System.out.print(" " + paramType.getName());
            }
            System.out.println();
        }
    }

}
