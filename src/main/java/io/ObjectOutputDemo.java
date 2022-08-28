package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

public class ObjectOutputDemo {
    public static void main(String[] args) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("person.dat"))) {
            Person p = new Person("janwee", LocalDate.of(1996, 10, 25), true);
            Person p1 = new Person("jake", LocalDate.of(1997, 9, 24), true, p);
            Person p2 = new Person("angela", LocalDate.of(1994, 6, 30), false, p);
            out.writeObject(p);
            out.writeObject(p1);
            out.writeObject(p2);
        }
    }
}

