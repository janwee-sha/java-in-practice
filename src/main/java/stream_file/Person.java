package stream_file;

import java.io.Serializable;
import java.time.LocalDate;

class Person implements Serializable {
    private static final long serialVersionUID = -8089915284224058336L;
    private String name;
    private LocalDate birth;
    private boolean male;
    private Person partner;
    private boolean married;

    public Person(String name, LocalDate birth, boolean male) {
        this.name = name;
        this.birth = birth;
        this.male = male;
    }

    public Person(String name, LocalDate birth, boolean male, Person partner) {
        this(name, birth, male);
        this.partner = partner;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", male=" + male +
                ", partner=" + partner +
                ", married=" + married +
                '}';
    }
}
