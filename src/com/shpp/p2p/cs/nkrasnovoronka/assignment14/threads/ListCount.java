package com.shpp.p2p.cs.nkrasnovoronka.assignment14.threads;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListCount {
    public static void main(String[] args) {
        List<Integer> primeNumbers = Stream.of(1,2,3,4,5,6,7,8,9,10).collect(Collectors.toList());
        MyThread leftPart = new MyThread(primeNumbers.subList(0, primeNumbers.size()/ 2), "leftPart");
        MyThread rightPart = new MyThread(primeNumbers.subList(primeNumbers.size()/ 2, primeNumbers.size()), "rightPart");

        leftPart.start();
        rightPart.start();
        try {
            leftPart.join();
            rightPart.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int res = leftPart.getPrimeNumbers() + rightPart.getPrimeNumbers();
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

class MyThread extends Thread{
    private String name;
    private List<Integer> numbers;
    private int primeNumbers;
    public MyThread(List<Integer> numbers, String name) {
        this.numbers = numbers;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Starting thread: " + name);
        calculatePrimeNumbers();
        System.out.println(primeNumbers);
    }

    private void calculatePrimeNumbers(){
        for (int i: numbers) {
            if(ListCount.isPrime(i)){
                primeNumbers++;
            }
        }
    }


    public int getPrimeNumbers() {
        return primeNumbers;
    }
}
