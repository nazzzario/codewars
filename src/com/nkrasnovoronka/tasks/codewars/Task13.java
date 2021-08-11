package com.nkrasnovoronka.tasks.codewars;


public class Task13 {
    public int factorial(int n) {
        if(n == 0){
            return 0;
        }
        if(n >= 0 && n <= 12){
            int res = 1;
            for (int i = 1; i <= n ; i++) {
                res *= i;
            }
            return res;
        }
        throw new IllegalArgumentException();
    }
}
