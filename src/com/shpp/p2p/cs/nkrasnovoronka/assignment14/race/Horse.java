package com.shpp.p2p.cs.nkrasnovoronka.assignment14.race;

import java.util.Random;

public class Horse implements Runnable{
    private String name;

    private final int FINAL_DISTANCE = 1000;

    private final int MIN_DISTANCE = 100;
    private final int MAX_DISTANCE = 200;

    private final int MIN_SLEEP = 400;
    private final int MAX_SLEEP = 500;
    private final Random random;


    public Horse(String name) {
        this.name = name;
        random = new Random();
    }

    @Override
    public void run() {

    }









    private int generateDistance(){
        return random.nextInt(MAX_DISTANCE - MIN_DISTANCE) + MIN_DISTANCE;
    }

    private int generateSleep(){
        return random.nextInt(MAX_SLEEP - MIN_SLEEP) + MIN_SLEEP;
    }

}
