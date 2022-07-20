package stream_file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SystemIn {
    public static void main(String[] args) throws Exception{
//        scannerIn();
        bufferedReaderIn();
    }
    private static void scannerIn(){
        Scanner in=new Scanner(System.in);
        System.out.println(in.nextLine());
        in.close();
    }
    private static void bufferedReaderIn() throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(in.readLine());
    }
}
