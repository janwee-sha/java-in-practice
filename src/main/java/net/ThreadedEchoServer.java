package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadedEchoServer {
    private static final Executor exec = Executors.newFixedThreadPool(1000);

    public static void main(String[] args) {
        try {
            int i = 1;
            ServerSocket s = new ServerSocket(7190);
            while (true) {
                Socket c = s.accept();
                System.out.println("Spawning" + i);
                exec.execute(new ThreadedEchoHandler(c));
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ThreadedEchoHandler implements Runnable {
    private Socket c;

    ThreadedEchoHandler(Socket c) {
        this.c = c;
    }

    @Override
    public void run() {
        try {
            try {
                InputStream inStream = c.getInputStream();
                OutputStream outStream = c.getOutputStream();
                Scanner in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream, true);

                out.println("Enter BYE to exit.");
                boolean done = false;
                while (!done && in.hasNextLine()) {
                    String line = in.nextLine();
                    out.println("Echo:" + line);
                    if ("BYE".equals(line.trim())) done = true;
                }
            } finally {
                c.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
