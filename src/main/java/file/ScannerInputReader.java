package file;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ScannerInputReader {
    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {
        Scanner in = new Scanner(new FileInputStream("Cheese.dat"), StandardCharsets.UTF_8.name());
//        PrintWriter out = new PrintWriter("info.dat", "UTF-8");
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line != null && line.length() > 0) {
                System.out.println(line);
            }
        }
    }
}
