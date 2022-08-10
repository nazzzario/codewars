import java.util.*;
import java.util.stream.IntStream;

public class MexicanWave {

    public static void main(String[] args) {
       System.out.println(Arrays.toString(wave("my hello")));
       int a = 12, b = 234;
    }

    public static String[] wave(String str) {
        int size = str.length();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < size; i++){
            res.add(upperCase(str, i));
        }
        return res.stream().filter(s -> !s.toLowerCase().equals(s)).toArray(String[]::new);
    }

    private static String upperCase(String string, int index){
        StringBuilder sb = new StringBuilder(string.toLowerCase());
        sb.setCharAt(index, Character.toUpperCase(string.charAt(index)));
        return sb.toString();
    }
    
}
 