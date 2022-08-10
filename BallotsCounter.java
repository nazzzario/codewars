import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BallotsCounter{
    public static void main(String[] args) {
        
    }

    public static String getWinner(final List<String> listOfBallots) {
        int numberOfVotes = listOfBallots.size() / 2;
        Map<String, Long> countBalotsMap = listOfBallots.stream()
                                                        .collect(Collectors.groupingBy(Function.identity(), 
                                                        Collectors.counting()));
        Entry<String, Long> max = countBalotsMap.entrySet().stream()
            .max(Comparator.comparing(Map.Entry<String, Long>::getValue))
            .get();

        return max.getValue() > numberOfVotes ? max.getKey() : null;
      }


}