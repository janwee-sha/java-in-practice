package validating.test;

import org.junit.jupiter.api.*;
import validating.CountedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountedListTest {
    private CountedList list;

    @BeforeAll
    static void beforeAllMsg() {
        System.out.println(">>> Starting CountedListTest");
    }

    @AfterAll
    static void afterAllMsg() {
        System.out.println(">>> Finished CountedListTest");
    }

    @BeforeEach
    public void initialize() {
        list = new CountedList();
        System.out.println("Set up for " + list.getId());
        for (int i = 0; i < 3; i++)
            list.add(Integer.toString(i));
    }

    @AfterEach
    public void cleanUp() {
        System.out.println("Cleaning up " + list.getId());
    }

    @Test
    public void insert() {
        System.out.println("Running testInsert()");
        assertEquals(3, list.size());
        list.add(1, "Insert");
        assertEquals(4, list.size());
        assertEquals("Insert", list.get(1));
    }

    @Test
    public void replace() {
        System.out.println("Running testReplace()");
        assertEquals(3, list.size());
        list.set(1, "Replace");
        assertEquals(3, list.size());
        assertEquals("Replace", list.get(1));
    }
}
