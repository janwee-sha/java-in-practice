package design_patterns.singleton;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.assertj.core.api.Assertions.assertThat;

public class DestroyingSingletonByReflectionTest {
    @Test
    public void useReflectionShouldDestroyEagerInitializedSingleton() {
        EagerInitializedSingleton instance1 = EagerInitializedSingleton.getInstance();
        EagerInitializedSingleton instance2 = null;
        try {
            Constructor<?>[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                constructor.setAccessible(true);
                instance2 = (EagerInitializedSingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(instance1 == instance2).isFalse();
    }
}
