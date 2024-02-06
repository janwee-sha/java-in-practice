package design_patterns.singleton;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class DoubleCheckedLockingSingleton {
    private volatile static DoubleCheckedLockingSingleton INSTANCE;

    public static DoubleCheckedLockingSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return INSTANCE;
    }

    private DoubleCheckedLockingSingleton() {
    }

    public void doSomething() {
    }
}
