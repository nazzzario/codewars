package com.nkrasnovoronka.tasks.codewars;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task19 {
    public static void main(String[] args) {
        Task19 task19 = new Task19();
        String hey = task19.encode("hey");
        System.out.println(hey);
        String decode = task19.decode(hey);
        System.out.println(decode);
    }
    public String encode(String text) {
        char[] chars = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c: chars) {
            sb.append(tripledBinary(c));
        }
        return sb.toString();
    }
    public String decode(String bits) {
        StringBuilder buffer = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < bits.length(); i = i + 3) {
            buffer.append(mostOftenChar(bits.substring(i, i + 3)));
            if(buffer.length() == 8){
                res.append((char) Integer.parseInt(buffer.toString(), 2));
                buffer = new StringBuilder();
            }

        }

        return res.toString();
    }

    private String tripledBinary(char ch){
        StringBuilder sb = new StringBuilder();
        String s = String.format("%8s", Integer.toBinaryString(ch)).replace(" ", "0");
        for(char c: s.toCharArray()){
            sb.append(c).append(c).append(c);
        }
        return sb.toString();
    }

    private String mostOftenChar(String s){
        Map<String, Long> collect =
                Arrays.stream(s.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return collect.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }

}
