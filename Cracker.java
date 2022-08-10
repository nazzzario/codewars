import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;

public class Cracker {

    private static Set<String> charsPremute = new HashSet<>();
  
    static String crackSha256(String hash, String chars) {
        premute("", chars);
        for(String str : charsPremute){
            String encodedString = encodeString(str);
            if(encodedString.equals(hash)){
                return str;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(crackSha256("b8c49d81cb795985c007d78379e98613a4dfc824381be472238dbd2f974e37ae", "deGioOstu"));
    }

    private static String encodeString(String text){
        try{
            MessageDigest mg = MessageDigest.getInstance("SHA-256");
            var bytes =  mg.digest(text.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(bytes);
        }catch(Exception ex){
            System.err.println("Unexpected error");
        }
        return null;
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte b : bytes) result.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        return result.toString();
     }

    private static void premute(String prefix, String chars){
        int charsLength = chars.length();
        
        if(charsLength == 0){
          charsPremute.add(prefix);
        }
        
        for(int i = 0; i < charsLength; i++){
          premute(prefix + chars.charAt(i), chars.substring(0, i) + chars.substring(i + 1, charsLength));
        }
        
      }
}
