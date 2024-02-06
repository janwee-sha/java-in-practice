package design_patterns.singleton;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class StaticBlockSingleton {
    private static final StaticBlockSingleton INSTANCE;

    // 类似EagerInitializedSingleton方式，且支持异常处理
    static {
        try {
            INSTANCE = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred in creating singleton instance", e);
        }
    }

    private StaticBlockSingleton() {
    }

    public static StaticBlockSingleton getInstance() {
        return INSTANCE;
    }

    public void doSomething(){}
}
