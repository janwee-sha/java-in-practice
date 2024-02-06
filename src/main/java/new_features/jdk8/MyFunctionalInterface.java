package new_features.jdk8;

@FunctionalInterface
public interface MyFunctionalInterface {
    void abstractMethod();

    default void defaultMethod() {
        System.out.println("Hello from default method.");
    }
}
