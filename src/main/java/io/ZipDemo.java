package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream("stand.zip"))) {
            ZipEntry entry;
            while ((entry = zin.getNextEntry()) != null) {
                System.out.println(entry.getName());
                zin.closeEntry();
            }

            /////

            Scanner in = new Scanner(zin);
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found.");
        }
    }
}
