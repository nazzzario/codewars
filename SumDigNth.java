public class SumDigNth {

    public static void main(String[] args) {
        System.out.println(sumDigNthTerm(10, new long[] {2, 1, 3}, 50));
        
    }

    public static long sumDigNthTerm(long initval, long[] patternl, int nthterm) {
        long sum = initval;
        for(int i = 0; i < nthterm - 1; i++){
            sum += patternl[i % patternl.length];
        }
        return sufOfDigits(sum);
    }

    private static long sufOfDigits(long number){
        long sum = 0;
        while(number > 0){
            long tmp = number % 10;
            sum += tmp;
            number = number / 10; 
        }
        return sum;
    }

}
