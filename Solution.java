
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) {
        String input = "the_Stealth_Warrior";
        System.out.println(toCamelCase(input));
    }

    static String toCamelCase(String s){
        Stream<String> first = Stream.of(s.split("[-_]")[0]);
        Stream<String> second = Stream.of(s.split("[-_]"));

        second.skip(1).map(str -> toCamel(str));

        return Stream.concat(first, second)
                     .collect(Collectors.joining());

      }

    private static String toCamel(String s){
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    // private static String firstToCael(String fist){
    //     String upper
    // }
    
}
