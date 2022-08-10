import java.util.function.BiFunction;
public class ListReduce {

    public static void main(String[] args) {
        reduce(
		new Node <Integer>(1,
			new Node<Integer> (2,
				new Node <Integer>(3)
			)
		), (a, b) -> a + b, 0);
    }

    static <T> T reduce(Node<T> head, BiFunction<T, T, T> f, T init) {
        Node<T> current = head;
        T res = null;
        
        while(current != null){
          res = f.apply(init, current.data);
          init = current.data;
          current = current.next;
        }
        
        return res;
      }
    
}

class Node<T> {
    public T data;
    public Node<T> next;
    
    Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
    
    Node(T data) {
      this(data, null);
    }
  }
