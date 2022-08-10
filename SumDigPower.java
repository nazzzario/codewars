import java.util.*;

public class SumDigPower {

    public static void main(String[] args) {
        System.out.println(sumDigPow(90, 100));
    }

    public static List<Long> sumDigPow(long a, long b) {
        List<Long> res = new ArrayList<>();
        for(long i = a; i <= b; i++){

            if(i < 10 || isDigSum(i)){
                res.add(i);
            }
        }
        return res;
    }

    private static boolean isDigSum(long num){
        Stack<Long> stack = new Stack<>();
        long sum = 0;
        int index = 1;
        long tmp = num;

        while(num > 0){
            stack.add(num % 10);
            num = num / 10;
        }

        while(!stack.empty()){
            sum += Math.pow(stack.pop(), index++);
        }

        return tmp == sum;
    }
    
}
