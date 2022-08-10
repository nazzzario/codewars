import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class BalancedNumber {
    
    public static void main(String[] args) {
        System.out.println(balancedNum(7));
    }

    public static String balancedNum(long number){
        List<Integer> numbers = Arrays.stream(Long.toString(number)
        .split("")).map(Integer::parseInt)
        .collect(Collectors.toList());
        int sum1;
        int sum2;

        if(numbers.size() % 2 != 0){
            sum1 = numbers.stream().limit(numbers.size() / 2).mapToInt(e -> e).sum();
            sum2 = numbers.stream().skip(numbers.size() / 2).mapToInt(e -> e).sum();
        }else{
            sum1 = numbers.stream().limit(numbers.size() / 2 - 1).mapToInt(e -> e).sum();
            sum2 = numbers.stream().skip(numbers.size() / 2 + 1).mapToInt(e -> e).sum();
        }
        return sum1 == sum2 ? "Balanced" : "Not Balanced";
    }
}
