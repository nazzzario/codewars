import java.util.*;
public class Keypad {

    private static Map<String, Integer> dict = new HashMap<>();

    static {
        dict.put("ADGJKMPTUW 1*#", 1);
        dict.put("BEHKNQUX0", 2);
        dict.put("CFILORVY", 3);
        dict.put("23456R8Z", 4);
        dict.put("79", 5);
    }


    public static void main(String[] args) {
        System.out.println(presses("HOW R U"));
    }

    public static int presses(String phrase) {
        int counter = 0;
        for(String s : phrase.split("")){
            counter += getValueByKeyElement(s);
        }
        return counter;
      }

      private static int getValueByKeyElement(String s){
          for(Map.Entry<String, Integer> e : dict.entrySet()){
              if(e.getKey().contains(s)){
                  return e.getValue();
              }
          }
          return 0;
      }
    
}
