import java.util.*;

public class Kata4 {
    public static void main(String[] args) {
        
    }

    public static int[] digitize(long n) {
        List<Long> res = new ArrayList<>();
        
        while(n > 0){
          long a =  n % 10;
          res.add(a);
          n = n / 10;
        }
        long [] larr = res.stream().mapToLong(x -> x).toArray();
        int [] intres = new int [larr.length];
        for(int i = 0; i < larr.length; i++){
            intres[i] = (int) larr[i];
        }
        return intres;
      }
}
