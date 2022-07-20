package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket s = new ServerSocket(7190)) {
            try (Socket c = s.accept()) {
                InputStream inStream = c.getInputStream();
                OutputStream outStream = c.getOutputStream();

                try (Scanner in = new Scanner(inStream)) {
                    PrintWriter out = new PrintWriter(outStream, true);
                    out.println("Enter BYE to exit...");

                    boolean done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo:" + line);
                        if ("BYE".equals(line.trim())) done = true;
                    }
                }
            }
        }
    }
}
