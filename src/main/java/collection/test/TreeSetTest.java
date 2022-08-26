package collection.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TreeSetTest {
    private static TreeSet<Integer> set;

    @BeforeEach
    public void beforeEach() {
        set = new TreeSet<>(Arrays.asList(8, 10, 3, 9, 1, 2));
    }

    @Test
    public void testHigherAndLower() {
        assertEquals(2, set.higher(1));
        assertNull(set.higher(10));
        assertEquals(1, set.lower(2));
        assertNull(set.lower(1));
    }

    @Test
    public void testCeilingAndFloor() {
        assertEquals(1, set.ceiling(1));
        assertEquals(10, set.ceiling(10));
        assertEquals(8, set.ceiling(7));
        assertEquals(2, set.floor(2));
        assertEquals(3, set.floor(4));
    }

    @Test
    public void testDescendingIterator() {
        Iterator<Integer> it = set.descendingIterator();
        int[] descending = new int[]{10, 9, 8, 3, 2, 1};
        for (int e : descending) {
            assertEquals(e, it.next());
        }
    }
}
