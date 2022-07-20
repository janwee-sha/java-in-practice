package net;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket();
            s.connect(new InetSocketAddress("127.0.0.1", 7190), 10000);
            Scanner in = new Scanner(s.getInputStream());
            PrintWriter out = new PrintWriter(s.getOutputStream());
            out.print("hello");
            out.flush();
            s.shutdownOutput();
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line);
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
