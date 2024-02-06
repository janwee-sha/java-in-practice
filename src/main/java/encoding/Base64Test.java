package encoding;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Test {
    public static void main(String[] args) {
        String hello = "ARG";
        byte[] bytes = hello.getBytes();
        byte[] base64 = Base64.getEncoder().encode(bytes);
        byte[] utf8 = hello.getBytes(StandardCharsets.UTF_8);
        System.out.println(new String(bytes));
        System.out.println(new String(base64));
        System.out.println(new String(utf8));
    }
}
