package design_patterns.singleton;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class StaticInnerClassSingleton {
    private static class SingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private StaticInnerClassSingleton() {
    }

    public void doSomething() {
    }
}
