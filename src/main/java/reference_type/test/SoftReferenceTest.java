package reference_type.test;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SoftReferenceTest {
    @BeforeAll
    static void beforeAllMsg() {
        System.out.println(">>> Starting SoftReferenceTest");
    }

    @AfterAll
    static void afterAllMsg() {
        System.out.println(">>> Finished SoftReferenceTest");
    }

    //add VM options "-Xmx20M" to see the performance
    @Test
    public void testLifeCycle() {
        Reference<byte[]> ref = new SoftReference<>(new byte[10 * 1024 * 1024]);
        assertNotNull(ref.get());
        System.gc();
        assertNotNull(ref.get());
        byte[] unused = new byte[12 * 1024 * 1024];//stack will overflow
        assertNull(ref.get());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
