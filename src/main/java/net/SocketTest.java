package net;

import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13);
        s.setSoTimeout(1000);
        //////
        s=new Socket();
        s.connect(new InetSocketAddress("time-A.timefreq.bldrdoc.gov", 13),1000);

        InputStream in = s.getInputStream();
        Scanner sc = new Scanner(in);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
        s.close();
    }
}
