package com.nkrasnovoronka.tasks.codewars;

import java.util.Stack;

public class Task5 {


    public static void main(String[] args) {
        System.out.println(evaluate("2 3 9 4 / + *"));
    }

    public static long evaluate(String s) {
        Stack<Integer> integerStack = new Stack<>();
        String[] split = s.split(" ");
        for(String val: split){
            if(val.matches("-?\\d+")){
                integerStack.push(Integer.parseInt(val));
            }
            else {
                int second = integerStack.pop();
                int first = integerStack.pop();
                integerStack.push(calculate(val, first, second));
            }
        }
        return integerStack.peek();
    }

    private static Integer calculate(String val, int first, int second) {
        switch (val){
            case "+":{
                return first + second;
            }
            case "-":{
                return first - second;
            }
            case "*":{
                return first * second;
            }
            case "/":{
                return first/second;
            }
            default:return 0;
        }
    }
}
