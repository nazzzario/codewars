package com.nkrasnovoronka.tasks.other.race;

import java.util.concurrent.ExecutionException;

public class HippodromeRace {
    public static void main(String[] args) throws ExecutionException {
        Race race = new Race();
        race.registerHorseToRace(new Horse("First", race));
        race.registerHorseToRace(new Horse("Second", race));
        race.registerHorseToRace(new Horse("Third", race));
        race.registerHorseToRace(new Horse("Fourth", race));
        race.registerHorseToRace(new Horse("Fifth", race));
        race.registerHorseToRace(new Horse("Six", race));
        race.registerHorseToRace(new Horse("Seven", race));
        race.registerHorseToRace(new Horse("Eight", race));
        race.registerHorseToRace(new Horse("Nine", race));
        race.registerHorseToRace(new Horse("Ten", race));

        race.startRace();
        System.out.println(race.getFinishPosition());
    }
}
