import java.util.*;

public class MySolution {

    public static void main(String[] args) {
        System.out.println(computeDepth(1));
    }

    public static int computeDepth(int n) {
        Set<String> storage = new HashSet<>();
        int counter = 0;
        int multy = 1;
        while(storage.size() < 10){
            String tmp = Integer.toString(n * multy);
            for(String s: tmp.split("")){
                storage.add(s);
            }
            multy++;
            counter++;

        }
        return counter;
    }
    
}
