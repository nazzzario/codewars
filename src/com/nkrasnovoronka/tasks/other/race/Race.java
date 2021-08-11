package com.nkrasnovoronka.tasks.other.race;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Race {
    private final Set<Horse> horses;
    private Map<Integer, Horse> finishPosition;
    private final AtomicInteger position;
    private ExecutorService service;

    public Race() {
        horses = new HashSet<>();
        finishPosition = new ConcurrentHashMap<>();
        position = new AtomicInteger(1);
    }

    public void registerHorseToRace(Horse horse){
        horses.add(horse);
    }

    public void startRace(){
        service = Executors.newFixedThreadPool(horses.size());
        List<Future> futures = new ArrayList<>();
        for(Horse h: horses){
            futures.add(service.submit(h));
        }
        for(Future f: futures){
            try {
                f.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        service.shutdown();
    }

    public Map<Integer, Horse> getFinishPosition() {
        return finishPosition;
    }

    public void setFinishPosition(Map<Integer, Horse> finishPosition) {
        this.finishPosition = finishPosition;
    }

    public AtomicInteger getPosition() {
        return position;
    }
}

