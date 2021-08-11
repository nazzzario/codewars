package com.nkrasnovoronka.tasks.codewars;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

//Moves in squared strings (I)
public class Task14 {

    public static void main(String[] args) {
       String s = "abcd\nefgh\nijkl\nmnop";
        String s1 = vertMirror(s);
        System.out.println(s1);
        System.out.println(horMirror(s));
    }
    public static String vertMirror (String strng) {
        List<String> strings = Arrays.asList(strng.split("\n"));
        return strings.stream().map(s -> new StringBuilder(s).reverse().toString()).collect(Collectors.joining("\n"));
    }
    public static String horMirror (String strng) {
        List<String> strings = Arrays.asList(strng.split("\n"));
        Collections.reverse(strings);
        return String.join("\n", strings);
    }
    public static String oper(Function<String, String> operator, String s) {
        return operator.apply(s);
    }
}
