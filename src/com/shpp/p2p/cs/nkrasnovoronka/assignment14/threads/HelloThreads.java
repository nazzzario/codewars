package com.shpp.p2p.cs.nkrasnovoronka.assignment14.threads;

public class HelloThreads {
    private static final int sleepConstant = 1000;
    public static void main(String[] args) {
        for (int i = 0; i < 49; i++) {
            new HelloThread("Thread: " + i, sleepConstant - i).start();
        }
    }
}
class HelloThread extends Thread{

    private int sleepTime;
    public HelloThread(String name, int sleepTime) {
        super(name);
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        sayHello();
    }

    private synchronized void sayHello() {
        try {
//            Thread.sleep(sleepTime);
            wait();
            System.out.println(getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
