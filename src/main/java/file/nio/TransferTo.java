package file.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

//改进GetChannel，直接连接此通道到彼通道
public class TransferTo {
    private static final String src = "Cheese.dat", tar = "Cheese1.dat";

    public static void main(String[] args) {
        try (FileChannel in = new FileInputStream(src).getChannel();
             FileChannel out = new FileOutputStream(tar).getChannel()) {
            in.transferTo(0, in.size(), out);
            //或者目标通道调用transferFrom
//            out.transferFrom(in,0,in.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
