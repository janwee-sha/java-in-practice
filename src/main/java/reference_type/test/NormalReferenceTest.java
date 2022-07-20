package reference_type.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import reference_type.T;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NormalReferenceTest {
    @BeforeAll
    static void beforeAllMsg() {
        System.out.println(">>> Starting NormalReferenceTest");
    }

    @AfterAll
    static void afterAllMsg() {
        System.out.println(">>> Finished NormalReferenceTest");
    }

    @Test
    public void testLifeCycle() {
        System.out.println("Running testLifeCycle()");
        T t = new T();
        System.gc();
        assertNotNull(t);
        t = null;
        System.gc();
        assertNull(t);
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
    }
}
