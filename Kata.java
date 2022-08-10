public class Kata {
    public static void main(String[] args) {
        int res = findEvenIndex(new int[] {1,100,50,-51,1,1});
        System.out.println(res);
    }

    public static int findEvenIndex(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            int left = getLeftSum(arr, i);
            int right = getRightSum(arr, i);

            if(left == right){
                return i;
            }
        }
        return -1;
    }

    private static int getLeftSum(int[] arr, int index){
        int sum = 0;
        for(int i = 0; i < index; i++){
            sum+=arr[i];
        }
        return sum;
    }

    private static int getRightSum(int[] arr, int index){
        int sum = 0;
        for(int i = index + 1; i < arr.length; i++){
            sum+=arr[i];
        }
        return sum;
    }
    
}
