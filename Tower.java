import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tower {
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(towerBuilder(5)));
    }

    public static String[] towerBuilder(int nFloors){
      List<String> tower = new ArrayList<>();
      StringBuilder sb = new StringBuilder();
      int k = 0;

      for (int i = 1; i <= nFloors; ++i, k = 0) {
        for (int space = 1; space <= nFloors - i; ++space) {
            sb.append(" ");
        }
  
        while (k != 2 * i - 1) {
            sb.append("* ");
          ++k;
        }

        tower.add(sb.toString());
        sb.setLength(0);
      }
      return tower.stream().toArray(String[]::new);
    }
    
}
