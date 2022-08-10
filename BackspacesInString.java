import java.util.Stack;
import java.util.stream.Collectors;

public class BackspacesInString {
    public static void main(String[] args) {
        BackspacesInString bis = new BackspacesInString();
        String res = bis.cleanString("abc####d##c#");
        System.out.println(res);
    }

    public String cleanString(String s) {
        Stack<String> storage = new Stack<>();
        for(String el : s.split("")){
            if(el.equals("#")){
                if(!storage.isEmpty()){
                    storage.pop();
                }
            }else{
                storage.push(el);
            }
        }

        return storage.stream().collect(Collectors.joining(""));
    }
    
}
