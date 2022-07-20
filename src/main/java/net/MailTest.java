package net;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class MailTest {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        try (InputStream inStream = Files.newInputStream(Paths.get("mail", "mail.properties"))) {
            props.load(inStream);
        }
        Scanner in = new Scanner(System.in);
        if (in.hasNextLine()) {
            List<String> lines = Files.readAllLines(Paths.get(in.nextLine()), StandardCharsets.UTF_8);
            String line;
        }
    }
}
