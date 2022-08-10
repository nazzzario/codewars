import java.util.StringJoiner;

public class Window{
    public static void main(String[] args) {
        System.out.println(makeAWindow(3));
    }

    public static String makeAWindow(int num){
      StringJoiner sj = new StringJoiner("\n");
      sj.add(generateLine(num));
      for(int i = 0; i < num * 2 + 1; i++){
          sj.add(generateWindow(num, i));
      }  
      sj.add(generateLine(num));  
      return sj.toString();
    }

    private static String generateLine(int num){
        return "-".repeat(num * 2 + 3);
    }
    private static String generateWindow(int num, int index){
        StringBuilder sb = new StringBuilder();
        sb.append("|");
        for(int i = 0; i < 2; i++){
            sb.append(".".repeat(num)).append("|");
        }
        if(index == num){
            sb.setCharAt(num + 1, '+');
            String tmp = sb.toString().replace(".", "-");
            sb = new StringBuilder(tmp);
        }
 


        return sb.toString();
    }

}