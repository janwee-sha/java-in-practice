package file.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class GetChannel {
    private static final String name = "data.txt";

    public static void main(String[] args) {
        //文件输出
        try (FileChannel fc = new FileOutputStream(name).getChannel()) {
            fc.write(ByteBuffer.wrap("Hello,Janwee.".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //文件读入/输出
        try (FileChannel fc = new RandomAccessFile(name, "rw").getChannel()) {
            fc.position(fc.size());//移动到文件末尾
            fc.write(ByteBuffer.wrap("Hello,NIO".getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //文件读入
        try (FileChannel fc = new FileInputStream(name).getChannel()) {
            ByteBuffer buff = ByteBuffer.allocate(1024);
            while (fc.read(buff) > 0) {
                buff.flip();//准备写入
                System.out.println(StandardCharsets.UTF_8.newDecoder().decode(buff).toString());
                buff.clear();//准备读取
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
