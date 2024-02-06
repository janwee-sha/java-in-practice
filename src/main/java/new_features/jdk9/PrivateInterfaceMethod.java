package new_features.jdk9;

public interface PrivateInterfaceMethod {
    private void message() {
        System.out.println("Hi, Java 9.");
    }

    default void sayHi() {
        message();
    }
}
