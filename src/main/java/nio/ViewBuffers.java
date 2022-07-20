package nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;

public class ViewBuffers {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 97});
        System.out.print("Byte Buffer: ");
        while (bb.hasRemaining()) {
            System.out.print(
                    bb.position() + " -> " + bb.get());
            if (bb.hasRemaining())
                System.out.print(", ");
        }
        System.out.println();

        CharBuffer cb = ((ByteBuffer) bb.rewind()).asCharBuffer();
        System.out.print("Char Buffer: ");
        while (cb.hasRemaining()) {
            System.out.print(
                    cb.position() + " -> " + cb.get());
            if (cb.hasRemaining())
                System.out.print(", ");
        }
        System.out.println();

        System.out.print("Char Buffer(printed by toString): ");
        System.out.println(cb.rewind().toString());

        IntBuffer ib = ((ByteBuffer) bb.rewind()).asIntBuffer();
        System.out.print("Int Buffer: ");
        while (ib.hasRemaining()) {
            System.out.print(
                    ib.position() + " -> " + ib.get());
            if (ib.hasRemaining())
                System.out.print(", ");
        }
        System.out.println();

        LongBuffer lb = ((ByteBuffer) bb.rewind()).asLongBuffer();
        System.out.print("Long Buffer: ");
        while (lb.hasRemaining()) {
            System.out.print(
                    lb.position() + " -> " + lb.get());
            if (lb.hasRemaining())
                System.out.print(", ");
        }
        System.out.println();
    }
}
