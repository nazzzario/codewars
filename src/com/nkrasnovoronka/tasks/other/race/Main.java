package com.nkrasnovoronka.tasks.other.race;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) throws ExecutionException {
        List<Horse> horseList = new ArrayList<>();
        horseList.add(new Horse("First", atomicInteger));
        horseList.add(new Horse("Second", atomicInteger));
        horseList.add(new Horse("Third", atomicInteger));
        horseList.add(new Horse("Fourth", atomicInteger));
        horseList.add(new Horse("Fifth", atomicInteger));
        horseList.add(new Horse("Six", atomicInteger));
        horseList.add(new Horse("Seven", atomicInteger));
        horseList.add(new Horse("Eight", atomicInteger));
        horseList.add(new Horse("Nine", atomicInteger));
        horseList.add(new Horse("Ten", atomicInteger));

        ExecutorService service = Executors.newFixedThreadPool(10);
            for (Horse h : horseList) {
                service.submit(h);
            }

        service.shutdown();
    }
}
