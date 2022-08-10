import java.util.*;

public class CaesarCipher {

private final char [] vocabular = new char []{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                                            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
                                            'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {
        String u = "I should have known that you would have a perfect answer for me!!!";
        // List<String> v = Arrays.asList("J vltasl rlhr ", "zdfog odxr ypw", " atasl rlhr p ", "gwkzzyq zntyhv", " lvz wp!!!");
        System.out.println(movingShift(u, 1));
    }

    public static List<String> movingShift(String s, int shift) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i))){
                char newChar = (char)(s.charAt(i) + shift);
                
            }else{
                sb.append(s.charAt(i));
            }
            
            shift = (shift + 1) % 26;
            System.out.println(shift);
        }
        System.out.println(sb);
		return res;
	}
	
	public static String demovingShift(List<String> s, int shift) {
		return null;
	}
}
