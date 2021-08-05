package com.shpp.p2p.cs.nkrasnovoronka.assignment14.threads;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListCount {
    public static void main(String[] args) {
        List<Integer> primeNumbers = Stream.of(1,2,3,4,5,6,7,8,9,10).collect(Collectors.toList());
        FutureTask<Integer> leftPart = new FutureTask<>(new MyThread(primeNumbers.subList(0, primeNumbers.size()/ 2)));
        FutureTask<Integer> rightPart =  new FutureTask<>(new MyThread(primeNumbers.subList(primeNumbers.size()/ 2, primeNumbers.size())));

        Thread t1 = new Thread(leftPart);
        Thread t2 = new Thread(rightPart);

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int res = 0;
        try {
            res = leftPart.get() + rightPart.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Total number of primes: " + res);



    }



    protected static boolean isPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}

class MyThread implements Callable<Integer> {
    private final List<Integer> numbers;

    public MyThread(List<Integer> numbers) {
        this.numbers = numbers;
    }
    
    @Override
    public Integer call() {
        int primeNumbers = 0;
        for (int i: numbers) {
            if(ListCount.isPrime(i)){
                primeNumbers++;
            }
        }
        return primeNumbers;
    }
}
