package com.nkrasnovoronka.tasks.codewars;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task11 {
    public static void main(String[] args) {
        System.out.println(generateColor(new Random()));
    }

    public static String generateColor(Random r) {
        int rColor = r.nextInt(256);
        int gColor = r.nextInt(256);
        int bColor = r.nextInt(256);
        System.out.println(rColor);
        System.out.println(bColor);
        System.out.println(gColor);
        return String.format("#%02x%02x%02x", rColor, gColor, bColor);
    }

}
