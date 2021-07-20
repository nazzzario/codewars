package com.shpp.p2p.cs.nkrasnovoronka.assignment14;

import java.util.ArrayList;
import java.util.List;

public class Task12 {
    public static Double evaluate(String expression) {

        return -1.0;
    }

    public static void main(String[] args) {
        List<Lexeme> lexemes = Lexeme.lexAnalyze("-5.26968088E8");
        System.out.println(lexemes);
        LexemeBuffer lexemeBuffer = new LexemeBuffer(lexemes);
        System.out.println(expr(lexemeBuffer));
    }
    public static class Lexeme{
        LexemeType lexemeType;
        String value;

        public Lexeme(LexemeType lexemeType, String value) {
            this.lexemeType = lexemeType;
            this.value = value;
        }

        public Lexeme(LexemeType lexemeType, Character value) {
            this.lexemeType = lexemeType;
            this.value = value.toString();
        }

        @Override
        public String toString() {
            return "Lexeme{" +
                    "lexemeType=" + lexemeType +
                    ", value='" + value + '\'' +
                    '}';
        }

        public static List<Lexeme> lexAnalyze(String expression){
            List<Lexeme> lexemes = new ArrayList<>();
            int pos = 0;
            while (pos < expression.length()){
                char c = expression.charAt(pos);
                switch (c){
                    case '(':
                        lexemes.add(new Lexeme(LexemeType.L_BRACKET, c));
                        pos++;
                        continue;
                    case ')':
                        lexemes.add(new Lexeme(LexemeType.R_BRACKET, c));
                        pos++;
                        continue;
                    case '+':
                        lexemes.add(new Lexeme(LexemeType.PLUS, c));
                        pos++;
                        continue;
                    case '-':
                        int tmp = pos;
                        char c1 = expression.charAt(++tmp);
                        if(c1 <= '9' && c1 >= '0' || c1 == '.' || c1 == 'E'){
                            StringBuilder sb = new StringBuilder();
                            do {
                                sb.append(c);
                                pos++;
                                if(pos >= expression.length()){
                                    break;
                                }
                                c = expression.charAt(pos);
                            }while (c <= '9' && c >= '0' || c == '.' || c == 'E');
                            lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
                        }else {
                            lexemes.add(new Lexeme(LexemeType.MINUS, c));
                        }
                        pos++;
                        continue;
                    case '*':
                        lexemes.add(new Lexeme(LexemeType.MULTIPLY, c));
                        pos++;
                        continue;
                    case '/':
                        lexemes.add(new Lexeme(LexemeType.DIVISION, c));
                        pos++;
                        continue;
                    default:
                        if(c <= '9' && c >= '0' || c == '.' || c == 'E'){
                            StringBuilder sb = new StringBuilder();
                            do {
                                sb.append(c);
                                pos++;
                                if(pos >= expression.length()){
                                    break;
                                }
                                c = expression.charAt(pos);
                            }while (c <= '9' && c >= '0' || c == '.' || c == 'E');
                            lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
                        }else {
                            if(c != ' '){
                                throw new RuntimeException("Invalid input: " + c);
                            }
                            pos++;
                        }
                }
            }
            lexemes.add(new Lexeme(LexemeType.EOF, ""));


            return lexemes;
        }
    }
    public static class LexemeBuffer{
        int pos;
        List<Lexeme> lexemes;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next(){
            return lexemes.get(pos++);
        }

        public void back(){
            pos--;
        }

        public int getPos() {
            return pos;
        }
    }
    public enum LexemeType{
        L_BRACKET, R_BRACKET, MINUS, PLUS, MULTIPLY, DIVISION,
        NUMBER, EOF
    }

    public static Double expr(LexemeBuffer lexemeBuffer){
        Lexeme lexeme = lexemeBuffer.next();
        if(lexeme.lexemeType == LexemeType.EOF){
            return (double) 0;
        }else {
            lexemeBuffer.back();
            return plusminus(lexemeBuffer);
        }


    }

    public static Double plusminus(LexemeBuffer lexemeBuffer){
        Double v = multdiv(lexemeBuffer);
        while (true){
            Lexeme lexeme = lexemeBuffer.next();
            switch (lexeme.lexemeType){
                case MINUS:
                    v -= multdiv(lexemeBuffer);
                    break;
                case PLUS:
                    v += multdiv(lexemeBuffer);
                    break;
                default:
                    lexemeBuffer.back();
                    return v;
            }
        }
    }

    public static Double multdiv(LexemeBuffer lexemeBuffer){
        Double v = factor(lexemeBuffer);
        while (true){
            Lexeme lexeme = lexemeBuffer.next();
            switch (lexeme.lexemeType){
                case MULTIPLY:
                    v *= factor(lexemeBuffer);
                    break;
                case DIVISION:
                    v /= factor(lexemeBuffer);
                    break;
                default:
                    lexemeBuffer.back();
                    return v;
            }
        }
    }

    public static Double factor(LexemeBuffer lexemeBuffer){
        Lexeme lexeme = lexemeBuffer.next();
        switch (lexeme.lexemeType){
            case NUMBER:
                return Double.parseDouble(lexeme.value);
            case L_BRACKET:
                Double expr = expr(lexemeBuffer);
                lexeme = lexemeBuffer.next();
                if(lexeme.lexemeType != LexemeType.R_BRACKET){
                    throw new RuntimeException("Invalid expression");
                }
                return expr;
            default:{
                throw new RuntimeException("Invalid expression");
            }
        }


    }

}



