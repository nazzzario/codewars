import java.util.*;
import java.util.stream.Collectors;

public class VersionManager {

    private List<Integer> majoreMinorePatch = new ArrayList<>();
    private Map<Long, List<Integer>> cache = new HashMap<>();
    private long cacheIndex = 1;

    public static void main(String[] args) {
        String res = new VersionManager("56.32.7").major().release();
        System.out.println(res);
    }

    public VersionManager(){
        setDefoultValues();
    }

    public VersionManager(String versionString){
        setValues(versionString);
    }

    public VersionManager major(){
        cache.put(cacheIndex++, new ArrayList<>(majoreMinorePatch));
        majoreMinorePatch.set(0, majoreMinorePatch.get(0) + 1);
        majoreMinorePatch.set(1, 0);
        majoreMinorePatch.set(2, 0);
        return this;
    }

    public VersionManager minor(){
        cache.put(cacheIndex++, majoreMinorePatch);
        majoreMinorePatch.set(1, majoreMinorePatch.get(1) + 1);
        majoreMinorePatch.set(2, 0);
      return this;
    }

    public VersionManager patch(){
        cache.put(cacheIndex++, majoreMinorePatch);
        majoreMinorePatch.set(2, majoreMinorePatch.get(2) + 1);
      return this;
    }

    public VersionManager rollback(){
        if(cache.isEmpty()){
            throw new RuntimeException("Cannot rollback!");
        }
        majoreMinorePatch = cache.remove(cacheIndex - 1);

      return this;
    }

    public String release(){
        return majoreMinorePatch.stream()
               .map(String::valueOf)
               .collect(Collectors.joining("."));
    }

    private void setDefoultValues(){
        majoreMinorePatch.add(0);
        majoreMinorePatch.add(0);
        majoreMinorePatch.add(1);
    }

    private void setValues(String versionString){
        if(versionString.isBlank()){
            setDefoultValues();
        }else{
            if(!isValid(versionString)){
                throw new RuntimeException("Error occured while parsing version!");
            }
            setValuesFromString(versionString);
        }
    }

    private void setValuesFromString(String vString){
        String arr [] = vString.split("\\.");
        for(int i = 0; i < 3; i++){
          if(arr.length < i + 1){
             majoreMinorePatch.add(0);
          }else{
             majoreMinorePatch.add(Integer.parseInt(arr[i]));
          }
        }
    }

    private boolean isValid(String version){
        String [] arr = version.split("\\.");
        if(arr.length < 3 ){
            for(String s : arr){
              if(!s.matches("\\d+")){
                  return false;
              }  
            }
            return true;
        }
        
        return arr[0].matches("\\d+") 
               && arr[1].matches("\\d+") 
               && arr[2].matches("\\d+");
    }
    
}