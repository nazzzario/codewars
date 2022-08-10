import java.util.Arrays;

public class Solution4 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solve(new String[]{"abode","ABc","xyzD"})));
    }

    public static int[] solve(String[] arr){
        int [] res = new int [arr.length];
        int counter = 0;
        for(int i = 0; i < arr.length; i++){
          char [] tmp = arr[i].toLowerCase().toCharArray();

          for(int j = 0; j < tmp.length; j++){
            int index = tmp[j] - 96;
            if(index == j + 1){
              counter++;
            }
          }
          res[i] = counter;
          counter = 0;
          
        }
        return res;

    }
}
