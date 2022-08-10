public class NumberFun {
    public static void main(String[] args) {
        long res = findNextSquare(114);
        System.out.println(res);
    }

    public static long findNextSquare(long sq) {
        int sqrt = (int)Math.sqrt(sq);
        if(sqrt * sqrt == sq){
            return (sqrt + 1) * (sqrt + 1);
        }

        return -1; 
    }
}
