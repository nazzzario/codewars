import java.util.*;

public class CodeDecode {
    public static void main(String[] args) {
        System.out.println("Expecting " + "0011110011110111011100011000");
        System.out.println("Actual    " + code("77338"));
        System.out.println("Decode " + decode("0011110011110111011100011000"));
    }

    public static String code(String strng) {
        StringBuilder sb = new StringBuilder();
        var intArr = stringToArrayOfIntegers(strng);

        for(int i : intArr){
            sb.append(codeInteger(i));
        }
        return sb.toString();
    }



    public static String decode(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder tmp = new StringBuilder(str);

        while(!tmp.toString().isEmpty()){
            for(int i = 0; i < 10; i++){
                String code = codeInteger(i);
                if(tmp.toString().startsWith(code)){
                    tmp.replace(0, code.length(), "");
                    sb.append(i);
                }
            }
        }
        return sb.toString();
    }

    private static String codeInteger(int i){
        int baseI = i % 10;
        int k = Integer.toBinaryString(baseI).length();
        String digits = "0".repeat(k - 1) + 1;
        String d = Integer.toBinaryString(i);
        return digits + d;
    }

    private static int [] stringToArrayOfIntegers(String str){
        return Arrays.stream(str.split(""))
                     .mapToInt(Integer::parseInt)
                     .toArray();

    }
}
