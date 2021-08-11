package com.nkrasnovoronka.tasks.other.race;

import java.util.concurrent.ThreadLocalRandom;

public class Horse implements Runnable {
    private final int MIN_DISTANCE = 100;
    private final int MAX_DISTANCE = 200;

    private final int MIN_SLEEP = 400;
    private final int MAX_SLEEP = 500;

    private final int FINISH_DISTANCE = 1000;

    private final String name;
    private int currentDistance;
    private final Race race;

    public Horse(String name, Race race) {
        this.name = name;
        this.race = race;
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
        race.getFinishPosition().put(race.getPosition().getAndIncrement(), this);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                '}';
    }
}
