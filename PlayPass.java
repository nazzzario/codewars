public class PlayPass {

    public static void main(String[] args) {
        System.out.println(playPass("BORN IN 2015!", 1));
    }

    public static String playPass(String s, int n) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(Character.isAlphabetic(s.charAt(i))){
               char c = shiftChar(s.charAt(i), n);
               sb.append(changeCase(c, i));
            }
            else if(Character.isDigit(s.charAt(i))){
                int number = (Integer.parseInt(s.charAt(i) + ""));
                sb.append((9 - number));
            }
            else{
                sb.append(s.charAt(i));
            }
        }
		return sb.reverse().toString();
	}

    private static char shiftChar(char c, int shift){
        int tmp = (int) c;

        if(Character.isUpperCase(c)){
            return (char) ((tmp + shift - 'A') % 26 + 'A');
        }
        
        return (char) ((tmp + shift - 'a') % 26 + 'a');

    }

    private static char changeCase(char c, int index){
        if(index % 2 == 0){
            return Character.toUpperCase(c);
        }

        return Character.toLowerCase(c);
    }
    
    
}
