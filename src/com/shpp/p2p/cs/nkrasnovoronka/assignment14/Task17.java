package com.shpp.p2p.cs.nkrasnovoronka.assignment14;

import java.util.StringJoiner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Moves in squared strings (IV)
public class Task17 {
    public static void main(String[] args) {
        String s = "abcd\nefgh\nijkl\nmnop";
        System.out.println(selfieDiag2Counterclock(s));
    }


    public static String rot90Counter(String strng) {
        return Stream.of(diag2Sym(strng)
                .split("\n"))
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining("\n"));
    }
    public static String diag2Sym(String strng) {
        StringJoiner sj = new StringJoiner("\n");
        StringBuilder sb = new StringBuilder();
        String[] split = strng.split("\n");
        for (int i = split.length - 1; i >= 0; i--) {
            for (String s : split) {
                sb.append(s.charAt(i));
            }
            sj.add(sb.reverse());
            sb.setLength(0);
        }
        return sj.toString();
    }
    public static String selfieDiag2Counterclock(String strng) {
        StringJoiner sj = new StringJoiner("\n");
        StringBuilder sb = new StringBuilder();
        String[] split = strng.split("\n");
        String[] rot = rot90Counter(strng).split("\n");
        String[] diag = diag2Sym(strng).split("\n");
        for (int i = 0; i < split.length; i++) {
            sb.append(split[i])
                    .append("|")
                    .append(diag[i])
                    .append("|")
                    .append(rot[i]);

            sj.add(sb);
            sb.setLength(0);
        }
        return sj.toString();
    }
    public static String oper(UnaryOperator<String> operator, String s) {
        return operator.apply(s);
    }
}
