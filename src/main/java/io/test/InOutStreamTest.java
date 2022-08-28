package io.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InOutStreamTest {
    private static final byte[] BYTES = new byte[]{'a', 'b', 'c'};
    private File file = new File("words.txt");

    @BeforeEach
    public void beforeEach() throws IOException {
        try (OutputStream out = new FileOutputStream(file)) {
            out.write(BYTES);
        }
    }

    @AfterEach
    public void afterEach() throws IOException {
        Files.delete(file.toPath());
    }

    @Test
    public void testReadWrite() throws IOException {
        try (InputStream in = new FileInputStream(file)) {
            int i = 0;
            while (in.available() > 0) {
                assertEquals(BYTES[i++], in.read());
            }
        }
    }
}
