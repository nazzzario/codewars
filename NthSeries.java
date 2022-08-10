import java.text.DecimalFormat;

public class NthSeries {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    
    public static void main(String[] args) {
        System.out.println(seriesSum(5));
    }

    public static String seriesSum(int n) {
        double res = 0;
        int divisor = 1;
        for(int i = 0; i < n; i++){
        res += (1.0 / divisor);
        divisor += 3;
        }
    
        return df.format(res)+ "";
	}
}
