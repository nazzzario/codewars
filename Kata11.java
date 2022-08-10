import java.util.Arrays;

public class Kata11{
    public static void main(String[] args) {
        Object[][] a =  {{9, 4, 5, 8, 0, 9, 1, 1, 3}, {5, 0, 8, 5, 4, 3, 4, 5, 5}, {9, 5, 1, 6, 7, 8, 8, 9, 5},
        {9, 9, 7, 8, 6, 2, 0, 2, 9}, {4, 7, 9, 3, 6, 6, 2, 6, 1}, {0, 3, 5, 7, 0, 5, 1, 6, 2},
        {7, 8, 4, 1, 0, 1, 6, 0, 0}, {0, 2, 1, 8, 8, 7, 6, 0, 1}, {4, 3, 5, 6, 5, 4, 0, 3, 6}};
        System.out.println(KiyoLCM(a));
    }

    public static long KiyoLCM(Object[][] a){
        var sumArray = Arrays.stream(a)
        .map(o -> Arrays.stream(o)
                  .filter(e -> isValidNumber(e))
                  .mapToInt(i -> (int) i)
                  .sum())
        .mapToLong(i -> i)
        .distinct()          
        .reduce(1, (x, y) -> x * (y / gcd(x, y)));            
     return sumArray;
    }

    private static boolean isValidNumber(Object obj){
        return (obj instanceof Integer) && ((Integer) obj) % 2 != 0;
    }
    
    private static long gcd(long a, long b){
        if (b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}