package collection.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {
    private final String[] words = "My dog has fleas".split(" ");
    private Queue<String> queue;

    @BeforeEach
    public void initialize() {
        System.out.println("Initializing Stack...");
        queue = new LinkedList<>();
        for (String s : words)
            queue.offer(s);
    }

    @Test
    public void testPeek() {
        System.out.println("Running testPeek()...");
        int i = 0;
        while (!queue.isEmpty()) {
            assertEquals(words[i], queue.peek());
            assertEquals(words.length - i++, queue.size());
            queue.remove();
        }
    }
}
