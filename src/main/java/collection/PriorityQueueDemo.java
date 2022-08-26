package collection;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Character> queue = new PriorityQueue<>(),queue2=new PriorityQueue<>(Collections.reverseOrder());
        for (char c:"i am janwee.".toCharArray()) {
            queue.offer(c);
            queue2.offer(c);
        }
        QueueDemo.print(queue);
        QueueDemo.print(queue2);
    }
}
