package primary.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class StringSplitTest {
    private static final String str1 = "", str2 = "123";


    @BeforeAll
    static void beforeAllMsg() {
        System.out.println(">>> Starting StringSplitTest");
    }

    @AfterAll
    static void afterAllMsg() {
        System.out.println(">>> Finished StringSplitTest");
    }

    @Test
    public void testSplit() {
        assertArrayEquals(new String[]{""}, str1.split(","));
        assertArrayEquals(new String[]{"123"}, str2.split(","));
    }
}
