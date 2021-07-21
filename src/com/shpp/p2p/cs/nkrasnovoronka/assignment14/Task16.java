package com.shpp.p2p.cs.nkrasnovoronka.assignment14;

import java.util.StringJoiner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Moves in squared strings (III)
public class Task16 {
    public static void main(String[] args) {
        String s = "abcd\nefgh\nijkl\nmnop";
        System.out.println(selfieAndDiag1(s));
    }


    public static String diag1Sym(String strng) {
        StringJoiner sj = new StringJoiner("\n");
        StringBuilder sb = new StringBuilder();
        String[] split = strng.split("\n");
        for (int i = 0; i < split.length; i++) {
            for (String s : split) {
                sb.append(s.charAt(i));
            }
            sj.add(sb);
            sb.setLength(0);
        }
        return sj.toString();
    }
    public static String rot90Clock(String strng) {
        strng = diag1Sym(strng);
        return Stream.of(strng.split("\n"))
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining("\n"));

    }
    public static String selfieAndDiag1(String strng) {
        StringJoiner sj = new StringJoiner("\n");
        StringBuilder sb = new StringBuilder();
        String[] diag = diag1Sym(strng).split("\n");
        String[] split = strng.split("\n");
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i]).append("|").append(diag[i]);
            sj.add(sb);
            sb.setLength(0);
        }
        return sj.toString();
    }
    public static String oper(UnaryOperator<String> operator, String s) {
        return operator.apply(s);
    }
}
