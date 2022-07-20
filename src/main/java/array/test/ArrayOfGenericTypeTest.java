package array.test;

import array.ArrayOfGenericType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOfGenericTypeTest {
    @BeforeAll
    static void beforeAllMsg() {
        System.out.println(">>> Starting ArrayOfGenericTypeTest");
    }

    @AfterAll
    static void afterAllMsg() {
        System.out.println(">>> Finished ArrayOfGenericTypeTest");
    }

    @Test
    public void elementType() {
        System.out.println("Running testElementType()");
        ArrayOfGenericType<Integer> arr = new ArrayOfGenericType<>(4);
        ArrayOfGenericType.Person p = new ArrayOfGenericType.Person("Bilbo");
        for (int i = 0; i < arr.length(); i++) {
            assertEquals(p, arr.get(i));
        }
    }
}
