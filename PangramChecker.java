import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PangramChecker {
    public static void main(String[] args) {
        
    }

    public boolean check(String sentence){
        String [] spl = sentence.replaceAll("\\W", "").toLowerCase().split("");
        Map<String, Long> map = Arrays.stream(spl)
              .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.size() == 26;
      }
    
}
