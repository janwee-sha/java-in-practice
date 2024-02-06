package new_features.jdk8.test;

import new_features.jdk8.MyFunctionalInterface;
import org.junit.jupiter.api.Test;

public class MyInterfaceTest {
    @Test
    public void testMyFunctionalInterface() {
        MyFunctionalInterface face = () ->
                System.out.println("Hello from custom functional interface!");
        face.abstractMethod();
    }
}
