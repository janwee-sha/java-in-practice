package primary.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import primary.StaticMetod;

public class StaticMethodTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println(">>> Starting StaticMethodTest.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(">>> Finished StaticMethodTest.");
    }

    @Test
    public void testAccessingViaInstance() {
        System.out.println("Testing accessing static method via instance.");

        StaticMetod instance = null;
        instance.aMethod();
        assert true;
    }

    @Test
    public void testAccessingViaClass() {
        System.out.println("Testing accessing static method via class.");

        StaticMetod.aMethod();
        assert true;
    }
}
