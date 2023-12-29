package org.example.section1;

import java.util.Arrays;

public class Section1 {
    public static void main(String[] args) {
        constructor();
        equality();
        generic();
    }

    private static void constructor(){
        System.out.println("Constructor;");
        Coordinate coordinate = new Coordinate(8);
        coordinate.values();
    }

    private static void referenceEquality(Object o1, Object o2){
        boolean b = o1 == o2;
        System.out.println(o1 + " == " + o2 + " is " + b);
    }

    private static void valueEquality(Object o1, Object o2){
        boolean b = o1.equals(o2);
        System.out.println(o1 + ".equals(" + o2 + ") is " + b);
    }

    private static void equality(){
        System.out.println("\nEquality;");

        System.out.println("null checking:");
        String nullObject = null;
        String normal = "string";
        try {
            nullObject.equals(normal);
            System.out.println("trying null.equals()");
        } catch (NullPointerException e){
            System.out.println("but caught " + e.getMessage());
        }
        boolean b1 = nullObject == null;
        System.out.println("null == null is " + b1);

        System.out.println("String checking:");
        String literal = "string";
        String anotherLiteral = "string";
        String object = new String("string");

        System.out.println("compare literal and another literal");
        referenceEquality(literal, anotherLiteral);
        valueEquality(literal, anotherLiteral);
        System.out.println("compare literal and object");
        referenceEquality(literal, object);
        valueEquality(literal, object);
        System.out.println("compare literal and raw String");
        referenceEquality(literal, "string");
        valueEquality(literal, "string");
        System.out.println("compare literal and raw String");
        referenceEquality(object, "string");
        valueEquality(object, "string");
        System.out.println("compare literal and new String");
        referenceEquality(object, new String("string"));
        valueEquality(object, new String("string"));
        System.out.println("compare raw String and raw String");
        referenceEquality("string", "string");
        valueEquality("string", "string");

    }

    private static <T> void generic(){
        System.out.println("\nGeneric;");

        GenericClass<Integer> g1 = new GenericClass<>(1);
        System.out.println(g1.getValue());
        GenericClass<String> g2 = new GenericClass<>("string");
        System.out.println(g2.getValue());

        T[] genericArray = (T[]) new Object[]{1,"string"};
        for (T t : genericArray) {
            System.out.println(t);
        }
    }
}
