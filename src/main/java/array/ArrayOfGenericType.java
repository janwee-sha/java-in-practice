package array;

import java.util.Arrays;
import java.util.Objects;

public class ArrayOfGenericType<T> {
    T[] array;

    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
//        array=new T[size]; //illegal statement
        array = (T[]) new Object[size];
        for (int i = 0; i < array.length; i++) {
            Object obj = new Person("Bilbo");//can put elements of any type except the basic types
            array[i] = (T) obj;
        }
    }

    public boolean equals(ArrayOfGenericType<T> other) {
        return Arrays.equals(this.array, other.array);
    }

    public int length() {
        return array.length;
    }

    public T get(int i) {
        return array[i];
    }

    public static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return name.equals(person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
