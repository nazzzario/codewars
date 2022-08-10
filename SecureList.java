import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class SecureList extends ArrayList<Integer>{
    private List<Integer> storage = new ArrayList<>();
    private int size = 0;

    public static void main(String[] args) {
        int[] base = new int[]{1, 2, 3, 4};
        SecureList secureList = new SecureList(base);
        System.out.println(secureList.get(0));
        System.out.println(secureList.get(1));
        System.out.println(secureList.size());
    }

    public SecureList(int[] array){
       for(int t: array){
           storage.add(t);
       }
       size = storage.size();
    }

    @Override
    public boolean add(Integer el){
        storage.add(el);
        size++;
        return true;
    }

    @Override
    public Integer get(int index){
        Integer elem = storage.get(index);
        storage.remove(index);
        return elem;
    }

    @Override
    public int size(){
        return storage.size();
    }

    @Override
    public String toString(){
        StringJoiner sj = new StringJoiner("[", ",", "]");
        for(int i: storage){
            sj.add(i + "");
        }
        storage.clear();
        size = 0;
        return sj.toString();
    }
}
