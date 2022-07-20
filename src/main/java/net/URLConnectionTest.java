package net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLConnectionTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.baidu.com/");
        URLConnection conn = url.openConnection();
        conn.connect();
        InputStream inStream = conn.getInputStream();
        Scanner in = new Scanner(inStream);
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
    }
}
