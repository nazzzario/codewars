package com.shpp.p2p.cs.nkrasnovoronka.assignment14;

public class Task9 {
    public static void main(String[] args) {
    }

    public static String[] flapDisplay(final String[] lines, final int[][] rotors) {
        String[] res = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            res[i] = flip(lines[i], rotors[i]);
        }

        return res;
    }

    private static String flip(String line, int [] rotor){

        StringBuilder sb = new StringBuilder(line);
        for (int i = 0; i < line.length(); i++) {
            sb = flipping(sb, i, line.length(), rotor[i]);
        }
        return sb.toString();

    }

    private static StringBuilder flipping(StringBuilder sb, int from, int to, int number){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ?!@#&()|<>.:=-+*/0123456789".toCharArray();
            for (int i = from; i < to; i++) {
                int index = getIndex(sb.charAt(i), chars);
                sb.setCharAt(i,chars[(number + index) % chars.length]);
            }
            return sb;
        }

    private static int getIndex(char charAt, char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if(charAt == chars[i]){
                return i;
            }
        }
        return -1;
    }
}
