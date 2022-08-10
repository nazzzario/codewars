import java.util.ArrayList;
import java.util.List;

public class Rank {
    public static void main(String[] args) {
        
    }

    public static String nthRank(String st, Integer[] we, int n) {
        if(st.isEmpty()){
            return "No participants";
        }

        String [] spl = st.split(",");
        List<String> res = new ArrayList<>();

        if(n > spl.length){
            return "Not enough participants";
        }

        





       return null;
    }

    private static int calclateWeight(String firstname, int weight){
        int som = 0;
        for(char c: firstname.toLowerCase().toCharArray()){
            som += c - 96;
        }
        return som + weight;
    }
}
