package io;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class FileChannels {
    public static void main(String[] args) throws Exception {
        FileChannel channel = FileChannel.open(Paths.get("", "Cheese.dat"));
        ByteBuffer buff = ByteBuffer.allocate(1024);
        while (channel.read(buff) > 0) {
            buff.flip();
            System.out.println(StandardCharsets.UTF_8.newDecoder().decode(buff).toString());
            buff.clear();
        }
        channel.close();
    }
}
