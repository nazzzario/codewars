import java.util.*;

public class EnoughIsEnough {

    public static void main(String[] args) {
      System.out.println(Arrays.toString(deleteNth( new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 0 )));
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
      if(maxOccurrences == 0){
        return new int [0];
      }


      Map<Integer, Integer> dict = new HashMap<>();
      for(int i = 0; i < elements.length; i++){
          if(dict.containsKey(elements[i])){
            if(dict.get(elements[i]) >= maxOccurrences){
              elements[i] = -1;
            }else{
              dict.put(elements[i], dict.get(elements[i]) + 1);
            }
          }else{
            dict.put(elements[i], 1);
          }
      }


    
		return Arrays.stream(elements)
                 .filter(e -> e != -1)
                 .toArray();
	}
    
}
