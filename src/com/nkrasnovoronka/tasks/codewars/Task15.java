package com.nkrasnovoronka.tasks.codewars;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

//Moves in squared strings (II)
public class Task15 {
    public static void main(String[] args) {
        String s = "abcd\nefgh\nijkl\nmnop";
//        System.out.println(rot(s));
        System.out.println(selfieAndRot(s));
    }


    public static String rot(String strng) {
        List<String> stringList = Arrays.asList(strng.split("\n"));
        Collections.reverse(stringList);
       return stringList.stream()
               .map(s -> new StringBuilder(s).reverse().toString())
               .collect(Collectors.joining("\n"));
    }
    public static String selfieAndRot(String strng) {
        List<String> stringList = Arrays.asList(strng.split("\n"));
        StringJoiner sj = new StringJoiner("\n");
        for(String s: stringList){
            sj.add(s + generateDotes(s.length()));
        }
        Collections.reverse(stringList);
        stringList.stream()
                .map(s -> new StringBuilder(s).reverse().toString())
                .forEach(s -> sj.add(generateDotes(s.length()) + s));
        return sj.toString();
    }
    public static String oper(UnaryOperator<String> operator, String s) {
        return operator.apply(s);
    }

    private static String generateDotes(int number){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            sb.append(".");
        }
        return sb.toString();
    }
}
