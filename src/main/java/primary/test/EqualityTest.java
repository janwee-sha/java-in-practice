package primary.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import primary.Equality;

import static org.junit.jupiter.api.Assertions.*;

public class EqualityTest {
    private Equality instance1, instance2;

    @BeforeAll
    static void beforeAllMsg() {
        System.out.println(">>> Starting EqualityTest");
    }

    @AfterAll
    static void afterAllMsg() {
        System.out.println(">>> Finished EqualityTest");
    }

    @BeforeEach
    public void initialize() {
        System.out.println("Setting up instance of Equality...");
        instance1 = new Equality(11);
        instance2 = new Equality(11);
    }

    @Test
    public void testEquals() {
        System.out.println("Testing equals...");

        assertEquals(instance1, instance2);
        assertEquals(instance1.hashCode(), instance2.hashCode());

        Integer i1 = 59;
        int i2 = 59;

        Integer i3 = Integer.valueOf(59), i4 = new Integer(59);
        assertSame(i1, i3);
        assertNotSame(i1, i4);
        assertSame(i1, i2);
        assertNotSame(i3, i4);
        assertSame(i2, i3);
        assertNotSame(i2, i4);

        //Integer.valueOf(i) will return a new Integer object if i>127||i<-128
        Integer i5 = -129, i6 = Integer.valueOf(-129);
        assertNotSame(i5, i6);
        Integer i7 = 128, i8 = Integer.valueOf(128);
        assertNotSame(i7, i8);
    }
}
