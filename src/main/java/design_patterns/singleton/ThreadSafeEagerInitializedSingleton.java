package design_patterns.singleton;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class ThreadSafeEagerInitializedSingleton {
    private static ThreadSafeEagerInitializedSingleton INSTANCE;

    private ThreadSafeEagerInitializedSingleton(){}

    public static synchronized ThreadSafeEagerInitializedSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadSafeEagerInitializedSingleton();
        }
        return INSTANCE;
    }

    public void doSomething(){}
}
