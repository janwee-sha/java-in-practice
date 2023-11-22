package serialization.test;

import org.junit.jupiter.api.Test;
import serialization.Person;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {
    @Test
    public void test() {
        Person jon = new Person(1, "Jon Snow", Person.Gender.MALE);
        jon.joinHouse("Stark");
        Person.TYPE_NAME = "PERSON";
        String filename = "jon.ser";

        // Serialization
        Path path = Paths.get(filename);
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
            out.writeObject(jon);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }


        Person jon1;

        // Deserialization
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
            System.out.println(Person.TYPE_NAME);
            Person.TYPE_NAME = "DESERIALIZED";
            jon1 = (Person) in.readObject();

            assertThat(jon1).isNotNull();
            assertThat(jon1.id()).isEqualTo(jon.id());
            assertThat(jon1.name()).isEqualTo(jon.name());
            assertThat(jon1.gender()).isEqualTo(jon.gender());
            assertThat(jon1.house()).isNull();
            System.out.println(Person.TYPE_NAME);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }
    }
}
