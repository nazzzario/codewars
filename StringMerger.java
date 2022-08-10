public class StringMerger {
    public static void main(String[] args) {
        System.out.println(isMerge("codewars", "cdwr", "oeas"));
        
    }

    public static boolean isMerge(String s, String part1, String part2) {
        String [] sArr = s.split("");
        String [] p1Arr = part1.split("");
        String [] p2Arr = part2.split("");

        for(int i = 0; i < sArr.length; i++){
            String p1Next = p1Arr[i];
            String p2Next = p2Arr[i];
            if(!sArr[i].equals(p1Next) && !sArr[i].equals(p2Next)){
                return false;
            }
        }
       return true;
    }
}
