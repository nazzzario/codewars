import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class SolutionArrays {

    public static void main(String[] args) {
       int res = nthSmallest(new int[]{3,2,6,8,2,3}, 3);
       System.out.println(res);
    }

    public static int nthSmallest(final int[] arr, final int n) {
        return IntStream.of(arr).sorted().boxed().collect(Collectors.toList()).get(n);
    }
}
