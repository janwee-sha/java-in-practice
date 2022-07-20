package object;

import java.util.Objects;

public class EqualsTest {
    public static void main(String[] args) {
        Student s1 = new Student("janwee", 60), s2 = new Student("janwee", 60);
        System.out.println(s1.equals(s2));
    }

    private static class Student {
        private String name;
        private double score;

        public Student(String name, double score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
