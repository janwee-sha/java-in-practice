package concurrency.threadlock;

import java.util.concurrent.TimeUnit;

public class HelloWorld {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Hello from new thread."));
        t.start();
//        Thread.yield();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from main thread.");
    }
}
