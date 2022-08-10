import java.util.*;

public class Conversion {
    public static void main(String[] args) {
        
    }


   private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    public String solution(int n) {
        int l =  map.floorKey(n);
        if ( n == l ) {
            return map.get(n);
        }
        return map.get(l) + solution(n-l);
    }
    
}
