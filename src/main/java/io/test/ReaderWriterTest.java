package io.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReaderWriterTest {
    private static final char[] CHARS = new char[]{'你', '好', '！'};
    private File file = new File("content.txt");

    @BeforeEach
    public void beforeEach() throws IOException {
        try (Writer out = new FileWriter(file)) {
            out.write(CHARS);
        }
    }

    @AfterEach
    public void afterEach() throws IOException {
        Files.delete(file.toPath());
    }

    @Test
    public void testReadWrite() throws IOException {
        try (Reader in = new FileReader(file)) {
            int i = 0;
            while (in.ready()) {
                assertEquals(CHARS[i++], in.read());
            }
        }
    }
}
