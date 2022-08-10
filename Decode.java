import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decode {

    public static void main(String[] args) {
        System.out.println(decode("1273409kuqhkoynvvknsdwljantzkpnmfgf"));
    }

    public static String decode(String r) {
        StringBuilder sb = new StringBuilder();

        Pattern pattern = Pattern.compile("(^\\d+)([a-z]+$)");
        Matcher matcher = pattern.matcher(r);

        Integer number = 0;
        String str = null;

        while(matcher.find()){
            number = Integer.parseInt(matcher.group(1));
            str = matcher.group(2);
        }

        for(char c: str.toCharArray()){
            for(int i = 0; i < 26; i++){
                if((i * number) % 26 == c - 'a' ){
                    sb.append((char) (i + 'a'));
                }
            }
        }

        if(sb.length() != str.length()){
            return "Impossible to decode";
        }

        return sb.toString();
     }  
}
