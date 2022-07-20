package net;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class URLTest {
    public static void main(String[] args) throws IOException, URISyntaxException {
        URI base = new URI("https://"), relative = new URI("www.baidu.com/");
        URL combine = base.resolve(relative).toURL();
        URL url = new URL("https://www.baidu.com/");
        printUrlInput(combine);
        printUrlInput(url);
    }

    private static void printUrlInput(URL url) throws IOException {
        InputStream inStream = url.openStream();
        Scanner in = new Scanner(inStream);
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
    }
}
