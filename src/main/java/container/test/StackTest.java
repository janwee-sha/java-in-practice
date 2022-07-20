package container.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StackTest {
    private final String[] words = "My dog has fleas".split(" ");
    private Deque<String> stack;

    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting StackTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished StackTest.");
    }

    @BeforeEach
    public void initialize() {
        System.out.println("Initializing Stack...");
        stack = new ArrayDeque<>();
        for (String s : words)
            stack.push(s);
    }

    @Test
    public void testPoll() {
        System.out.println("Running testPoll()...");
        int i = words.length - 1;
        while (!stack.isEmpty())
            assertEquals(words[i--], stack.poll());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPop() {
        System.out.println("Running testPop()...");
        int i = words.length - 1;
        while (!stack.isEmpty())
            assertEquals(words[i--], stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    public void testPeek() {
        System.out.println("Running testPeek()...");
        assertEquals(words[words.length - 1], stack.peek());
        assertEquals(4, stack.size());
    }
}

