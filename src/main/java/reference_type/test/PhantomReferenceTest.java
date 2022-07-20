package reference_type.test;

import org.junit.jupiter.api.Test;
import reference_type.T;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNull;

public class PhantomReferenceTest {
    private static final List<Object> LIST = new LinkedList<>();
    private static final ReferenceQueue<T> QUEUE = new ReferenceQueue<>();

    //add VM options "-Xmx20M" to see the performance
    @Test
    public void testLifeCycle() {
        System.out.println("Running testLifeCycle()");
        Reference ref = new PhantomReference<>(new T(), QUEUE);
        assertNull(ref.get());

        new Thread(() -> {
            while (true) {
                LIST.add(new byte[1024 * 1024 * 3]);
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted.");
                    Thread.currentThread().interrupt();
                }
                System.out.println(ref.get());
            }
        }).start();

        new Thread(() -> {
            while (true) {
                Reference<? extends T> poll = QUEUE.poll();
                if (poll != null) {
                    System.out.println("被回收了");
                } else {
                    System.out.println("队列无对象");
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted.");
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
