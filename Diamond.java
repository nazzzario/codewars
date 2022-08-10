public class Diamond {
    public static void main(String[] args) {
        System.out.print(print(5));
    }

    public static String print(int n) {
        if(n <= 0 || n % 2 == 0){
          return null;
        }
        int h = n / 2 + 1;

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= h; i = i + 2){
            for(int j = 1; j <= h - i; j ++){
                sb.append("_");
            }
            for(int k = 0; k < i; k++){
                sb.append("*");
            }
            sb.append("\n");
        }
        
        return sb.toString();
        
        }
}