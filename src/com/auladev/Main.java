package com.auladev;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        SopaLetras a = new SopaLetras(10);
        a.placeWordHorizontal("test", new int[]{1, 6});

        char[] testArr = new char[]{'a', 'b', 'c', 'd'};

        System.out.println(Arrays.toString(reverseCharArr(testArr)));

        String test = "Hello";
        char[] testC = test.toCharArray();

    }

    static char[] reverseCharArr(char[] from){
        char[] to = new char[from.length];
        for (int i = 0; i < from.length; i++) {
            to[i] = from[from.length -1 -i];
        }
        return to;
    }


}
