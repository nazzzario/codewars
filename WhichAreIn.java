import java.util.*;

public class WhichAreIn {
    public static void main(String[] args) {
        String a[] = new String[]{ "arp", "live", "strong" };
    	String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };

        String res [] = WhichAreIn.inArray(a, b);
        System.out.println(Arrays.toString(res));

    }

    public static String[] inArray(String[] array1, String[] array2) {
        Set<String> res = new TreeSet<>();
            for(String a1 : array1){
                for(String a2 : array2){
                    if(a2.contains(a1)){
                        res.add(a1);
                    }
                }
            }
        return res.stream()
                  .toArray(String [] :: new);
   }
    
}
