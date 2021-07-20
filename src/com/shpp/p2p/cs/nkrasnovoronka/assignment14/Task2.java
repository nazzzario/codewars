package com.shpp.p2p.cs.nkrasnovoronka.assignment14;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task2 {

    static String dr = "+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n"
            + "+1-541-984-3012 <P Reed> /PO Box 530; Pollocksville, NC-28573\n :+11-541-754-3010 156 <Paul Dive> Sequoia Alley PQ-67209\n"
            + "+1-741-984-3090 <Peter Reedgrave> _Chicago\n :+1-921-333-2222 <Anna Stevens> Haramburu_Street AA-67209\n"
            + "+1-111-544-8973 <Peter Pan> LA\n +1-921-512-2222 <Wilfrid Stevens> Wild Street AA-67209\n"
            + "<Peter Gone> LA ?+1-121-544-8974 \n <R Steell> Quora Street AB-47209 +1-481-512-2222\n"
            + "<Arthur Clarke> San Antonio $+1-121-504-8974 TT-45120\n <Ray Chandler> Teliman Pk. !+1-681-512-2222! AB-47209,\n"
            + "<Sophia Loren> +1-421-674-8974 Bern TP-46017\n <Peter O'Brien> High Street +1-908-512-2222; CC-47209\n"
            + "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n <P Salinger> Main Street, +1-098-512-2222, Denver\n"
            + "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n"
            + "+1-099-500-8000 <Peter Crush> Labrador Bd.\n +1-931-512-4855 <William Saurin> Bison Street CQ-23071\n"
            + "<P Salinge> Main Street, +1-098-512-2222, Denve\n"+ "<P Salinge> Main Street, +1-098-512-2222, Denve\n";


    public static void main(String[] args) {
        System.out.println(phone(dr, "+1-541-754-3010"));
    }

    public static  String phone(String strng, String num) {
        String[] lines = strng.split("\n");
        List<String> collect = Arrays.stream(lines).filter(s -> getPhone(s).equals(num)).collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        if(collect.size() > 1){
            return "Error => Too many people: " + num;
        }
        if(collect.isEmpty()){
            return  "Error => Not found: " + num;
        }
        String line = collect.get(0);
        sb.append("Phone => ").append(num).append(", ");
        String name = "";
        Pattern pattern = Pattern.compile("(?<=<).+(?=>)");
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()){
            name = matcher.group(0);
        }
        sb.append("Name => ").append(name).append(", ");
        String replaced = line.replace(name, "").replace(num, "").replaceAll("[^A-Za-z\\d. ]", " ");
        String collect1 = Arrays.stream(replaced.split(" ")).filter(s -> s.length() > 1).collect(Collectors.joining(" "));
        sb.append("Address => ").append(collect1.trim());


        return sb.toString();
    }

    private static String getPhone(String line){
        Pattern pattern = Pattern.compile("\\b\\+?\\d{1,2}-\\d{3}-\\d{3}-\\d{4}\\b");
        Matcher matcher = pattern.matcher(line);
        if(matcher.find()){
            return matcher.group();
        }
        return "";
    }
}
