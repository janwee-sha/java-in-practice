package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
  public static void print(Queue queue) {
    StringBuilder sb=new StringBuilder("[");
    while (!queue.isEmpty()){
      sb.append(queue.poll()).append(",");
    }
    sb.deleteCharAt(sb.length()-1).append("]");
    System.out.println(sb.toString());
  }
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    for(int i = 0; i < 10; i++){
      queue.offer(i);
    }
    print(queue);
  }
}
/* Output:
8 1 1 1 5 14 3 1 0 1
B r o n t o s a u r u s
*/
