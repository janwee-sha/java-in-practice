package file.nio;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileInfo {
    static void show(String id, Object p) {
        System.out.println(id + ": " + p);
    }

    static void info(Path p) {
        show("toString", p);
        show("exists", Files.exists(p));
        show("isRegularFile", Files.isRegularFile(p));
        show("isDirectory", Files.isDirectory(p));
        show("isAbsolute", p.isAbsolute());
        show("fileName", p.getFileName());
        show("parent", p.getParent());
        show("root", p.getRoot());
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }

    public static void main(String[] args) {
        info(Paths.get("C:", "Users", "Janwee", "Desktop", "Notes", "se-interview-questions", "README.md"));
        Path p = Paths.get("FileInfo.java");
        info(p);
        Path ap = p.toAbsolutePath();
        info(ap);
        info(ap.getParent());
        try {
            info(p.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }
        URI u = p.toUri();
        System.out.println("URI: " + u);
        Path puri = Paths.get(u);
        System.out.println(Files.exists(puri));
        File f = ap.toFile(); // Don't be fooled
    }
}
