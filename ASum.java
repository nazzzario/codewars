public class ASum {
    public static void main(String[] args) {
        System.out.println(findNb(91716553919377L));
    }

    public static long findNb(long m) {
        double s = (-1 + Math.sqrt(1 + 8 * Math.sqrt(m))) / 2;

		return s == Math.floor(s) ? (long) s : -1;
	}	
    
}
