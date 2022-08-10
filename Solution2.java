import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
       int res =  solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2);
       System.out.println(res);
    }

    public static int solveSuperMarketQueue(int[] customers, int n) {
        int [] res = new int[n];
        for(int i: customers){
            res[0] += i;
            Arrays.sort(res);
        }
        return res[n - 1];
    }
    
}
