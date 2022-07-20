package stream_file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("person.dat"))) {
            Person p = (Person) in.readObject(), p1 = (Person) in.readObject(), p2 = (Person) in.readObject();
            System.out.println(p);
            System.out.println(p1);
            System.out.println(p2);
        }
    }
}
