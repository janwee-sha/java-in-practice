package primary;

import java.util.Objects;

public class Equality {
    private int val;

    public Equality(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equality equality = (Equality) o;
        return val == equality.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }
}
