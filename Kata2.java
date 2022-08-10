public class Kata2 {
    public static void main(String[] args) {
        char c = findMissingLetter(new char[] { 'O','Q','R','S'  });
        System.out.println(c);
    }

    public static char findMissingLetter(char[] array){
        for(int i = 0; i < array.length - 1; i++){
            if(array[i] + 1 != array[i + 1]){
                char c = (char) (array[i] + 1);
                return c;
            }
        }
        return ' ';
    }
}
