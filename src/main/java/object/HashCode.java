package object;

import java.util.Objects;

public class HashCode {
    public static void main(String[] args) {
        String s1 = "janwee";
        StringBuilder sb1 = new StringBuilder(s1);
        String s2 = new String("janwee");
        StringBuilder sb2 = new StringBuilder(s2);

        printHashCode("s1", s1);
        printHashCode("sb1", sb1);
        printHashCode("s2", s2);
        printHashCode("sb2", sb2);

        Person p1 = new Person("janwee", 23), p2 = new Person("janwee", 23);
        printHashCode("p1", p1);
        printHashCode("p2", p2);
        printEquals(p1, p2);

        Tiger t1 = new Tiger("bob", 2), t2 = new Tiger("bob", 2);
        printHashCode("t1", t1);
        printHashCode("t2", t2);
        printEquals(t1, t2);
    }

    private static void printEquals(Object obj1, Object obj2) {
        System.out.println(obj1.equals(obj2));
    }

    private static void printHashCode(String name, Object obj) {
        System.out.printf("hashcode of object %s : %s\n", name, obj.hashCode());
    }
}

class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}

class Tiger {
    private String name;
    private Integer age;

    public Tiger(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tiger tiger = (Tiger) o;
        return Objects.equals(name, tiger.name) &&
                Objects.equals(age, tiger.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
