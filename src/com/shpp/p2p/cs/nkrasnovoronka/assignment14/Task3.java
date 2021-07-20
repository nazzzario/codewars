package com.shpp.p2p.cs.nkrasnovoronka.assignment14;

import java.util.Locale;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(getSoundex("Honeyman"));
    }

    public static String soundex(final String names) {

        return "";
    }

    private static String getSoundex(String name){

        name = name.toUpperCase();
        name = name.charAt(0) + name.substring(1).replaceAll("[HW]", "");
        char firstLetter = name.charAt(0);
                name = name.replaceAll("[BFPV]", "1")
                .replaceAll("[CGJKQSXZ]", "2")
                .replaceAll("[DT]", "3")
                .replaceAll("[L]", "4")
                .replaceAll("[MN]", "5")
                .replaceAll("[R]", "6")
                .replaceAll("(\\d)\\1+", "$1");

                name = name.charAt(0) + name.substring(1).replaceAll("[AEIOUY]", "");
        StringBuilder sb = new StringBuilder(name);
        if(sb.substring(0, 1).matches("[\\d]")){
            sb.setCharAt(0, firstLetter);
        }
        sb.setCharAt(0, firstLetter);
        sb.append("000");
        return sb.substring(0, 4);
    }
}
