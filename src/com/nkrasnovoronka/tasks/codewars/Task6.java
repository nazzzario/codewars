package com.nkrasnovoronka.tasks.codewars;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Task6 {

    public static void main(String[] args) {
        System.out.println(WhoIsNext(new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"}, 6));
    }

    public static String WhoIsNext(String[] names, int n) {
        final int personNum = names.length;
        int loop = 1;
        int curPersonQueueNum = personNum * loop;
        while (n > curPersonQueueNum){
            n -= curPersonQueueNum;
            loop*=2;
            curPersonQueueNum = personNum * loop;
        }
        n = (int) Math.ceil((double)n / loop);
        return names[n - 1];
    }
}
