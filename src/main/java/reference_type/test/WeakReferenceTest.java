package reference_type.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import reference_type.T;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WeakReferenceTest {
    @BeforeAll
    static void beforeAllMsg() {
        System.out.println(">>> Starting WeakReferenceTest");
    }

    @AfterAll
    static void afterAllMsg() {
        System.out.println(">>> Finished WeakReferenceTest");
    }

    @Test
    public void testLifeCycle() {
        Reference<T> ref = new WeakReference<>(new T());
        assertNotNull(ref.get());
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
        assertNull(ref.get());
    }
}
