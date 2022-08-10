import java.util.Arrays;
import java.util.stream.Collectors;

public class Kata8{
    public static void main(String[] args) {
        String s = "                           ";
        String res = reverseWords(s);
        System.out.println(res);
    }

    public static String reverseWords(final String original){
        if(original.matches("[ ]+")){
            return original;
        }
        String [] splited = original.split(" ");

        return Arrays.stream(splited)
        .map(StringBuilder::new)
        .map(sb -> sb.reverse())
        .collect(Collectors.joining(" "));
    }
}