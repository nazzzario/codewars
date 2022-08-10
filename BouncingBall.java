public class BouncingBall {

    public static void main(String[] args) {
       int res =  BouncingBall.bouncingBall(5.0, 0.83, 5.0);
       System.out.println(res);
    }

    public static int bouncingBall(double h, double bounce, double window) {
        int count = 0;
	    if(h > 0 && (bounce > 0 && bounce < 1) && window < h){
            while(h > window){
                count++;
                h = bounce * h;
                if(h > window){
                    count++;
                }
            }
            return count;
        }
        return -1;
      }
    
}
