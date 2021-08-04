package com.shpp.p2p.cs.nkrasnovoronka.assignment14.threads;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            Thread t = new Thread(new MyRunnable("Thread: " + i, 6000/(i + 1)));
            try {
                t.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            t.start();
        }
    }
}
