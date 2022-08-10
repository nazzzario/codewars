import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Abbreviator {
    public static void main(String[] args) {
        Abbreviator abv = new Abbreviator();
        String input = "monolithic-sits_sits. monolithic. a: sits'doggy";
        var res = abv.abbreviate(input);
        System.out.println(res);
    }

    public String abbreviate(String str) {
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("[a-zA-Z-]+");
        Matcher matcher = p.matcher(str);
        while(matcher.find()){
            String tmp = matcher.group();
            matcher.appendReplacement(sb, createAbbreviation(tmp));
        }
        return sb.toString();
      }
      
      private String createAbbreviation(String word){
        int l = word.length();
        if(l > 3){
            if(word.contains("-")){
                var arr = word.split("-");
                var res = Arrays.stream(arr)
                                .map(this::createAbbreviation)
                                .collect(Collectors.joining("-"));
                return res;
            }
          return word.charAt(0) + String.valueOf((l - 2)) + word.charAt(l - 1);
        }
        return word;
      }
    
    
}
