


public class DirReduction {
    public static void main(String[] args) {
        
    }

    public static String[] dirReduc(String[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            if (("NORTH".equals(arr[i]) && "SOUTH".equals(arr[i + 1])) ||
            ("SOUTH".equals(arr[i]) && "NORTH".equals(arr[i + 1])) ||
            ("EAST".equals(arr[i]) && "WEST".equals(arr[i + 1])) ||
            ("WEST".equals(arr[i]) && "EAST".equals(arr[i + 1]))) {
            arr[i] = null;
            arr[i + 1] = null;
        }
        }

        // String [] res = Arrays.stream(arr)
        // .filter(s -> s != null)
        // .toArray(String [] :: new);

        // if(res.length == arr.length){
        //     return res;
        // }

        return dirReduc(null);
    }
    
}
