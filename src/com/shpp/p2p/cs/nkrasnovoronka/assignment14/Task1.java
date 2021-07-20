package com.shpp.p2p.cs.nkrasnovoronka.assignment14;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Task1 {

    public static void main(String[] args) {
	// write your code here
    }
    public static int findIt(int[] a) {
        Map<Integer, Long> map = Arrays.stream(a).boxed().collect(groupingBy(Function.identity(), counting()));
        int odd = 0;
        for(Map.Entry<Integer, Long> entry : map.entrySet()){
            if(entry.getValue() % 2 != 0){
                odd = (int) entry.getKey();
            }
        }
        return odd;
    }
}
