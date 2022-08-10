public class Sum {
    public static void main(String[] args) {
        System.out.println(GetSum(0, 1));
    }

    public static int GetSum(int a, int b){
        if(a > b){
          return sumBetween(b, a);
        }
        if(b > a){
          return sumBetween(b, a);
        }
       return a;
      }
     
     private static int sumBetween(int n1, int n2){
       int sum = 0;
       for(int i = n1; i <= n2; ++i){
         sum += i;
       }
       return sum;
     }
}
