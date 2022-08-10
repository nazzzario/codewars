import java.security.KeyStore.Entry;
import java.util.*;

public class Kata7 {
    private static Map<String, Long> dict = new HashMap<>();

    {
        dict.put("COBOL", 1000L);
        dict.put("nonobject", 500L);
        dict.put("monolithic", 500L);
        dict.put("fax", 100L);
        dict.put("modem", 100L);
        dict.put("thickclient", 50L);
        dict.put("tape", 50L);
        dict.put("floppy", 50L);
        dict.put("oldschoolIT", 50L);
    }



    public static void main(String[] args) {
        String workloads = "slow!expensive!";
        System.out.println(roastLegacy(workloads));
    }

    public static String roastLegacy(String workloads){
        String ok = "These guys are already DevOps and in the Cloud and the business is happy!";
        String prop = "Burn baby burn disco inferno %d points earned in this roasting and %d complaints resolved!";
        int points = 0;
        int cases = 0;

        for(Map.Entry<String, Long> e: dict.entrySet()){
            if(workloads.contains(e.getKey())){
                workloads.replace(e.getKey(), "");
                points+= e.getValue();
                cases++;
            }
        }

        return cases == 0 && points == 0 ? ok : String.format(prop, points, cases);
    }
    
}
