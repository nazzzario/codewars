import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    public static void main(String[] args) {
        System.out.println(order("is2 Thi1s T4est 3a"));
    }

    public static String order(String words) {
        List<String> res = Arrays.asList(words.split(" "));
        return res.stream()
                .sorted(Comparator.comparingInt(s -> getNumber(s)))
                .collect(Collectors.joining(" "));
      }

    private static int getNumber(String str){
        return Integer.parseInt(str.replaceAll("\\D", ""));
    }
}
