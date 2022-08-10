import java.util.StringJoiner;

public class Solution3 {
    public static void main(String[] args) {
        String res = rangeExtraction(new int[] {-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20});
        System.out.println(res);
    
    }

    public static String rangeExtraction(int[] arr) {

       StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            int j = i;
            while (j < arr.length - 1 && arr[j] + 1 == arr[j + 1]) j++;
            if (i + 1 < j) {
                i = j;
                sb.append("-");
                sb.append(arr[i]);
            }
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}