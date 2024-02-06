package new_features.jdk9.test;

import new_features.jdk9.PrivateInterfaceMethod;
import org.junit.jupiter.api.Test;

public class PrivateInterfaceMethodTest {
    @Test
    public void callMethodShouldSucceed() {
        PrivateInterfaceMethod privateInterfaceMethod = new PrivateInterfaceMethod() {
            @Override
            public void sayHi() {
                PrivateInterfaceMethod.super.sayHi();
            }
        };
        privateInterfaceMethod.sayHi();
    }
}
