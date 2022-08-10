import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Plugboard {
    public static void main(String[] args) throws Exception {
        Plugboard plugboard = new Plugboard("ABAD");
        System.out.println(plugboard.process("A"));
        System.out.println(plugboard.process("B"));
        System.out.println(plugboard.process("C"));
        System.out.println(plugboard.process("."));
    }

    private Map<String, String> dict = new HashMap<>();
  
    public Plugboard(String wires) throws Exception {
         if(wires.length() % 2 != 0 || wires.length() < 2 
                                    || wires.length() > 20 
                                    || haveDuplicates(wires)){
           throw new Exception();
        }
      createDictionary(wires);
    }

    public String process(String wire) {
        if(!dict.containsKey(wire)){
            return wire;
        }
        return dict.get(wire);
    }
  
    private void createDictionary(String wires){
      String [] spl = wires.split("");
      for(int i = 0; i < wires.length() - 1; i = i + 2){
        dict.put(spl[i], spl[i + 1]);
        dict.put(spl[i + 1], spl[i]);
      }
  }

  private boolean haveDuplicates(String wires){
      Set<String> set = new HashSet<>(Arrays.asList(wires.split("")));
      return set.size() != wires.length();
  }
}
