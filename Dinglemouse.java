import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
public class Dinglemouse {
    private static final String RIGHT_RATS = "~O";
    private static final String LEFT_RATS = "O~";
    private static final String PIED_PIPER = "P";
    
    public static void main(String[] args) {
        System.out.println(countDeafRats("~O~O~O~OP~O~OO~"));
        int arr [] = {10, 1};
        // arr = Stream.of(arr).sorted(Collections.reverseOrder()).boxed().mapToInt(e -> e).toArray();

    }

    public static int countDeafRats(final String town) {
        String [] str = splitString(town);
        int piedPiperIndex = findPiedPiperIndex(str);
        int rats = 0;
        for(int i = 0; i < str.length; i++){
            if(i < piedPiperIndex && str[i].equals(RIGHT_RATS) || i > piedPiperIndex && str[i].equals(LEFT_RATS)){
                rats++;
            }
        }
        return str.length - rats - 1;
      }

    private static int findPiedPiperIndex(String[] str) {
        for (int i = 0; i < str.length; i++) {
           if(str[i].equals(PIED_PIPER)){
               return i;
           }
        }
        throw new NoSuchElementException();
    }

    private static String [] splitString(String str){
        List<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("(O~|~O|P)");
        Matcher matcher = pattern.matcher(str.replace(" ", "").trim());
        while(matcher.find()){
            list.add(matcher.group());
        }
        return list.stream().toArray(String [] :: new); 
    }


}
