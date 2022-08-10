import java.util.Arrays;

public class Kata9 {
    public static void main(String[] args) {
        String [] res = joust(new String[] {
            "$->    ",
            "    <-P"
       }, 1, 1);

       System.out.println(Arrays.toString(res));
    }

    public static String[] joust(String[] listField, int vKnightLeft, int vKnightRight) {
        StringBuilder knight1 = new StringBuilder(listField[0]);
        StringBuilder knight2 = new StringBuilder(listField[1]);

        while(vKnightLeft != 0 || vKnightRight != 0){
            knight1.deleteCharAt(knight1.length() - 1);
            knight1.insert(0, " ");
            vKnightLeft--;

            knight2.deleteCharAt(0);
            knight2.insert(knight2.length(), " ");
            vKnightRight--;


            if(knight1.indexOf(">") == knight2.indexOf("<")){
                return new String[]{knight1.toString(), knight2.toString()};
            }
        }




        return new String[] {knight1.toString(), knight2.toString()};
   }
    
}
