package new_features.jdk8;

import java.util.Optional;

public class Detective {
    public Detective(Address address) {
        this.address = address;
    }

    public static void main(String[] args) {
        Detective sherlock = new Detective(new Address("London"));
        System.out.println(Optional.of(sherlock).map(Detective::getAddress).map(Address::getCity).orElse("Null"));
    }

    private final Address address;

    public Address getAddress() {
        return address;
    }
}

class Address {

    private final String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
