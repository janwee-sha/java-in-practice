package file.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    private static final int SIZE = 1024;
    private static final String FILE_NAME = "data2.txt";

    public static void main(String[] args) {
        try (FileChannel fc = new FileOutputStream(FILE_NAME).getChannel()) {
            fc.write(ByteBuffer.wrap("Some text".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ByteBuffer buff = ByteBuffer.allocate(SIZE);

        try (FileChannel fc = new FileInputStream(FILE_NAME).getChannel()) {
            fc.read(buff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        buff.flip();
        //无法正常运行
        System.out.println(buff.asCharBuffer());
        //使用系统默认编码解码
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decoded using " + encoding + ": " + Charset.forName(encoding).decode(buff));

        //编码和打印
    }
}
