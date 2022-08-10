import java.util.*;

public class BraceChecker {
    public static void main(String[] args) {
        boolean res = isValid("{[])");
        System.out.println(res);
    }


  public static boolean isValid(String braces) {
      char[] charArray = braces.toCharArray();

      Stack<Character> stack = new Stack<>();
      for(char c: charArray){
          if(c == '(' || c == '{' || c == '['){
              stack.add(c);


              
          }else{
              if(stack.isEmpty()){
                  return false;
              }
              char fromStack = stack.pop();
              if(c == ')' && fromStack != '(' || 
                 c == '{' && fromStack != '}' || 
                 c == ']' && fromStack != '[' ){
                     return false;
                 }else {
                     stack.pop();
                 }   
          }
      }
    return true;
}



}
