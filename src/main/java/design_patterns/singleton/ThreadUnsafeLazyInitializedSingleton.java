package design_patterns.singleton;

import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
public class ThreadUnsafeLazyInitializedSingleton {
    private static ThreadUnsafeLazyInitializedSingleton INSTANCE;

    private ThreadUnsafeLazyInitializedSingleton(){}

    public static ThreadUnsafeLazyInitializedSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadUnsafeLazyInitializedSingleton();
        }
        return INSTANCE;
    }

    public void doSomething(){}
}
