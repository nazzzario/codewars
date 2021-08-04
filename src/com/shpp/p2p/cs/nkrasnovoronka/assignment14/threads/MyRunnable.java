package com.shpp.p2p.cs.nkrasnovoronka.assignment14.threads;

public class MyRunnable implements Runnable{
    private int timeToSleep;
    private String name;

    public MyRunnable(String name, int timeToSleep) {
        this.timeToSleep = timeToSleep;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(timeToSleep);
            System.out.println(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
