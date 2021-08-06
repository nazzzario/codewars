package com.shpp.p2p.cs.nkrasnovoronka.assignment14.threads;

import java.util.ArrayDeque;
import java.util.Deque;

public class HelloThreads {
    public static void main(String[] args) {
        BlockingDeque blockingDeque = new BlockingDeque();
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                Runnable task;
                try {
                    task = blockingDeque.get();
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();

        for (int i = 0; i < 50; i++) {
            Runnable task = getTask(String.valueOf(i));
            blockingDeque.put(task);
        }

        try {
            Thread.sleep(5000);
            thread.interrupt();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static Runnable getTask(String name) {
        return () -> {
            System.out.printf("Hello from thread (%s)%n", name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };
    }
}

class BlockingDeque {
    Deque<Runnable> tasks = new ArrayDeque<>();

    public synchronized Runnable get() throws InterruptedException {
        while (tasks.isEmpty()) {
            wait();
        }
        return tasks.pollLast();
    }

    public synchronized void put(Runnable task) {
        tasks.addLast(task);
        notifyAll();
    }


}


