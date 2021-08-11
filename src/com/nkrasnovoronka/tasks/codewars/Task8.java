package com.nkrasnovoronka.tasks.codewars;

import java.util.*;

public class Task8 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{ 5, 3, 1, 8, 0 })));
    }

    public static int[] sortArray(int[] array) {
        List<Integer> oddNumbers = new ArrayList<>();
        for(int a: array){
            if(a % 2  != 0){
                oddNumbers.add(a);
            }
        }

        oddNumbers.sort(Comparator.naturalOrder());
        Iterator<Integer> iterator = oddNumbers.listIterator();
        for (int i = 0; i < array.length; i++) {
            if(array[i] %2 != 0){
                if(iterator.hasNext()){
                    array[i] = iterator.next();
                }
            }
        }
        return array;
    }

}
