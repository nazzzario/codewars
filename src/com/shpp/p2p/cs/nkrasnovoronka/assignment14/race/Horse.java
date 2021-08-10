package com.shpp.p2p.cs.nkrasnovoronka.assignment14.race;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;

public class Horse implements Callable<Horse> {
    private final String name;
    private Integer distance;

    private final int FINAL_DISTANCE = 1000;

    private final int MIN_DISTANCE = 100;
    private final int MAX_DISTANCE = 200;

    private final int MIN_SLEEP = 400;
    private final int MAX_SLEEP = 500;

    private Phaser phaser;

    private final Random random;


    public Horse(String name) {
        this.name = name;
        distance = 0;
        random = new Random();
        phaser.register();
    }

    @Override
    public Horse call() {
        phaser.arriveAndAwaitAdvance();
        while (distance < FINAL_DISTANCE){
            move();
            sleep();
        }
        phaser.arriveAndDeregister();
        return this;
    }

    private void move(){
        distance = distance + generateDistance();
    }

    private void sleep(){
        try {
            Thread.sleep(generateSleep());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private int generateDistance(){
        return random.nextInt(MAX_DISTANCE - MIN_DISTANCE) + MIN_DISTANCE;
    }

    private int generateSleep(){
        return random.nextInt(MAX_SLEEP - MIN_SLEEP) + MIN_SLEEP;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                '}';
    }


}
