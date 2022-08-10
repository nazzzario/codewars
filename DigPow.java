import java.util.Stack;

public class DigPow {
    public static void main(String[] args) {
        long res = digPow(92, 1);
        System.out.println(res);
    }

    public static long digPow(int n, int p) {
        long root = calculateRoot(n, p);
        long div = root / n;
        if(root != n * p){
            return -1;
        }
        return div;
	}

    private static long calculateRoot(int number, int p){
        long res = 0;
        Stack<Integer> deque = new Stack<>();
        int powIndex = p;
        while(number > 0){
            int tmp = number % 10;
            deque.add(tmp);
            number = number / 10;
        }
        while(!deque.isEmpty()){
         int r = (int) Math.pow(deque.pop(), powIndex++);
         res += r;
        }

        return res;
    }
}
