package com.nkrasnovoronka.tasks.codewars;

public class Task22 {
    public static void main(String[] args) {
        String[] alice = new String[]{"plat", "rend", "bear", "soar", "mare", "pare", "flap", "neat", "clan", "pore"};
        String[] bob = new String[]{"boar", "clap", "farm", "lend", "near", "peat", "pure", "more", "plan", "soap"};
        int send = mutations(alice, bob, "send", 0);
        System.out.println(send);
    }
    public static int mutations(String[] alice, String[] bob, String word, int first) {
        int aliceCounter = 0;
        int bobCounter = 0;
        String w = word;
        while (aliceCounter < alice.length && bobCounter < bob.length){
            aliceCounter = findWord(alice, w, aliceCounter + 1);
            if(aliceCounter == -1 && bobCounter == -1){
                return -1;
            }


            if(aliceCounter == -1){
                return 1;
            }
            w = alice[aliceCounter];
            System.out.println("alice " + w);
            bobCounter = findWord(bob,w, bobCounter + 1);
            if(bobCounter == -1){
                return 0;
            }
            w = bob[bobCounter];
            System.out.println("bob " + w);
        }
        return -1;
    }

    private static int findWord(String [] arr, String word, int index){
        for (int i = index; i < arr.length; i++) {
            if(mutable(arr[i], word)){
                return i;
            }
        }
        return -1;
    }


    private static boolean mutable(String s, String word) {
        int mistakes = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != word.charAt(i)){
                mistakes++;
            }
        }
        return mistakes == 1;
    }
}
