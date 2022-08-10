import java.util.*;

public class LongestConsec {
    public static void main(String[] args) {
        String res = longestConsec(new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 15);
        //String res = longestConsec(new String[] {"itvayloxrp","wkppqsztdkmvcuwvereiupccauycnjutlv","vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2);
    
        System.out.println(res);
    }

    public static String longestConsec(String[] strarr, int k) {
        if(k < 0 || k > strarr.length){
            return "";
        }
        if(k == 1){
          Arrays.sort(strarr, (s1,s2) -> Integer.compare(s2.length(), s1.length()));
         return strarr[0];
        }
        List<String> consecList = new ArrayList<>();
        for(int i = 0; i < strarr.length - 1; i++){
            int tmp = 0;
            int index = i;
            StringBuilder sb = new StringBuilder();
            while(tmp != k){
                sb.append(strarr[index++]);
                tmp++;
            }
            consecList.add(sb.toString());
        }
        System.out.println(consecList);
        return consecList.stream().sorted((s1,s2) -> Integer.compare(s2.length(), s1.length())).findFirst().orElse("");
    }
    
}
