public class Max {
    
    public static void main(String[] args) {
        int [] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum contiguous sum is " +
                                       sequence(a));
    }

    public static int sequence(int[] arr) {
        int size = arr.length;
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for(int i = 0; i < size; i++){
            if (arr[i] > maxEndingHere + arr[i]) {
                maxEndingHere = arr[i];
            } else
                maxEndingHere = maxEndingHere + arr[i];
     
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;

            }
        }
        return maxSoFar;
      }
}
