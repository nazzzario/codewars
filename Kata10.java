import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.Collector;

public class Kata10 {
    public static void main(String[] args) {
        System.out.println(numberOfPairs(new String[] {"red", "red"}));
    }

    public static int numberOfPairs(String[] gloves) {
        Map<String, Long> dict = Stream.of(gloves)
                                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));;
        int res = 0;
        for(Entry<String, Long> e: dict.entrySet()){
            res += e.getValue() / 2;
        }
        return res;
      }
}
