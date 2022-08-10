import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BitMarchArray {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(BitMarch(8)));
    }


	public static int[][] BitMarch(int n) {
        List<int []> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append("1");
        }
        n = Integer.parseInt(sb.toString(), 2);
        while(n <= 255){
            res.add(numberToBitArray(n));
            n = n * 2;
        }
		return res.stream().toArray(int [][]:: new);
	}

    private static int[] numberToBitArray(int number){
        String str = String.format("%8s", Integer.toBinaryString(number)).replaceAll(" ", "0");
        return Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
    }
}
