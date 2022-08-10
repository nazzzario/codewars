public class Arge {
    public static void main(String[] args) {
        int res = nbYear(1500, 5, 100, 5000);
        System.out.println(res);
    }

        
    public static int nbYear(int p0, double percent, int aug, int p) {
        int counter = 0;
        int sum = p0;
        while(sum < p){
          sum += sum * (percent/100) + aug;
          counter++;
        }
        
        
        return counter;
      }
    
}
