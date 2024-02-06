package file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileIOExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //FileInputStream
        try (FileInputStream fin = new FileInputStream("poet.txt")) {
            int bytesAvailable = fin.available();
            if (bytesAvailable > 0) {
                byte[] data = new byte[bytesAvailable];
                fin.read(data);
                show(new String(data));
            }
        }

        //System.in
        Scanner scanner = new Scanner(System.in);
        show("From Scanner:" + scanner.nextLine());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("From BufferedReader:" + reader.readLine());
    }

    private static void show(Object o) {
        System.out.println(o);
    }
}
