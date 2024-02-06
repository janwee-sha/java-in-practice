package design_patterns.singleton;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class EagerInitializedSingleton {
    private static final EagerInitializedSingleton INSTANCE = new EagerInitializedSingleton();

    private EagerInitializedSingleton() {
    }

    public static EagerInitializedSingleton getInstance() {
        return INSTANCE;
    }

    public void doSomething(){}
}
