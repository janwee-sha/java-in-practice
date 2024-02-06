package design_patterns.singleton;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class SerializedSingleton implements Serializable {
    @Serial
    private static final long serialVersionUID = -7604766932017737115L;

    private SerializedSingleton() {
    }

    private static class SingletonHolder {
        private static final SerializedSingleton INSTANCE = new SerializedSingleton();
    }

    public static SerializedSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    // 提供readResolve()方法以防止序列化反序列化后生成不同的对象，破坏单例模式
    @Serial
    protected Object readResolve() {
        return getInstance();
    }
}

class SerializedSingletonTest {
    @Test
    public void deserializationShouldNotCreateANewInstance() throws IOException, ClassNotFoundException {
        SerializedSingleton instance1 = SerializedSingleton.getInstance();
        SerializedSingleton instance2;
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("SerializedSingleton.ser"))) {
            out.writeObject(instance1);
        }

        try (ObjectInput in = new ObjectInputStream(new FileInputStream("SerializedSingleton.ser"))) {
            instance2 = (SerializedSingleton) in.readObject();
        }
        assertThat(instance1.hashCode() == instance2.hashCode()).isTrue();
    }
}
