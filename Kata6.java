import java.util.*;
import java.util.stream.Collectors;

public class Kata6 {
    public static void main(String[] args) {
        String res = reverseWords("double  spaces h");
        System.out.print(res);
    }

    public static String reverseWords(final String original){
        return Arrays.stream(original.split(" "))
          .map(StringBuilder::new)
          .map(s -> s.reverse().toString())
          .collect(Collectors.joining(" "));
      }
}