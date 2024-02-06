package file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipIOExample {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("poet.zip");
        try (ZipInputStream zin = new ZipInputStream(
                Files.newInputStream(path))) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
                System.out.println(entry.getName());
            }
        }

        try (ZipOutputStream zout = new ZipOutputStream(Files.newOutputStream(path))) {
            zout.putNextEntry(new ZipEntry("Hello.txt"));
        }
    }
}
