package com.nkrasnovoronka.tasks.other.race;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Horse implements Runnable {
    private final int MIN_DISTANCE = 100;
    private final int MAX_DISTANCE = 200;

    private final int MIN_SLEEP = 400;
    private final int MAX_SLEEP = 500;

    private final int FINISH_DISTANCE = 1000;

    private final String name;
    private int currentDistance;
    private final AtomicInteger position;
    private volatile int finishPosition = 1;

    public Horse(String name, AtomicInteger position) {
        this.name = name;
        this.position = position;
    }

    private void move(){
        int moveDistance = ThreadLocalRandom.current().nextInt(MIN_DISTANCE, MAX_DISTANCE);
        currentDistance += moveDistance;
    }

    private void sleep(){
        int sleepTime = ThreadLocalRandom.current().nextInt(MIN_SLEEP, MAX_SLEEP);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        while (currentDistance < FINISH_DISTANCE){
            move();
            sleep();
        }
        finishPosition = position.getAndIncrement();
        System.out.printf("Horse %s finished in position %s%n", name, finishPosition);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", finishPosition=" + finishPosition +
                '}';
    }
}
