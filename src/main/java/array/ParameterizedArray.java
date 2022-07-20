package array;

public class ParameterizedArray {
    public static class ClassParameter<T> {
        public T[] f(T[] args) {
            return args;
        }
    }

    public static class MethodParameter {
        public static <T> T[] f(T[] args) {
            return args;
        }
    }
}