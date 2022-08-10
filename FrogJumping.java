public class FrogJumping {
    public static void main(String[] args) {
        solution(new int[]{1, 2, 1, 2, -3, -4});
    }

    public static int solution(int[] a) {
        int jumpNumbers = 0;
        int possition = 0;
        
        while(possition < a.length && possition >= 0){
            possition += a[possition];
            if(jumpNumbers > a.length){
                return -1;
            }
            jumpNumbers++;
        }
        return jumpNumbers;
     }    
}
