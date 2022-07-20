package nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

//视图缓冲区（View Buffer）是通过特定的基本类型的窗口来查看底层ByteBuffer
public class IntBufferDemo {
    private static final int SIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(SIZE);
        IntBuffer ib = bb.asIntBuffer();
        //保存int数组
        ib.put(new int[]{11, 42, 12, 22});
        //绝对位置读写
        System.out.println(ib.get(3));
        ib.put(3, 1314);
        //在充值缓冲区前设置新的限制
        ib.flip();

        while (ib.hasRemaining()) {
            System.out.println(ib.get());
        }
    }
}
