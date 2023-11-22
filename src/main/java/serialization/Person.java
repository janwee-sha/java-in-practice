package serialization;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Person implements Serializable {
    private long id;
    private String name;

    private Gender gender;

    private transient String house;

    public static String TYPE_NAME;

    public enum Gender {
        MALE,
        FEMALE
    }

    public Person(long id, String name, Gender gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public void joinHouse(String house) {
        this.house = house;
    }

    public long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Gender gender() {
        return gender;
    }

    public String house() {
        return house;
    }
}
