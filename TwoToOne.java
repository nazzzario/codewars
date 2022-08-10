import java.util.Arrays;
import java.util.stream.Collectors;

public class TwoToOne {
    public static void main(String[] args) {
        String res = longest("aretheyhere", "yestheyarehere");
        System.out.println(res);
    }

    public static String longest (String s1, String s2) {
        String merged = s1 + s2;
        return Arrays.stream(merged.split(""))
               .distinct()
               .sorted()
               .collect(Collectors.joining());
     }
}