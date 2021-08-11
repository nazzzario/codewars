package com.nkrasnovoronka.tasks.codewars;

public class Task7 {
    public static void main(String[] args) {

    }

    public static String alphabetWar(String fight){
        char cha[] = fight.toCharArray();
        int left = leftPower(cha);
        int right = rightPower(cha);
        if(left > right){
            return "Left side wins!";
        }
        if(right >left){
            return "Right side wins!";
        }
        return "Let's fight again!";
    }

    private static int leftPower(char[] chars){
        int left = 0;
//        w - 4
//        p - 3
//        b - 2
//        s - 1
        for(char c: chars){
            switch (c){
                case 'w':{
                    left += 4;
                    break;
                }
                case 'p':{
                    left+= 3;
                    break;
                }
                case 'b':{
                    left+= 2;
                    break;
                }
                case 's':{
                    left+=1;
                    break;
                }
            }
        }
        return left;
    }
    private static int rightPower(char[] chars){
        int right = 0;
//        w - 4
//        p - 3
//        b - 2
//        s - 1
        for(char c: chars){
            switch (c){
                case 'm':{
                    right += 4;
                    break;
                }
                case 'q':{
                    right+= 3;
                    break;
                }
                case 'd':{
                    right+= 2;
                    break;
                }
                case 'z':{
                    right+=1;
                    break;
                }
            }
        }
        return right;
    }
}
