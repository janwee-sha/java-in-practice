package concurrency.objectsharing;

import concurrency.annotation.NotThreadSafe;

@NotThreadSafe
public class UnsafeSequence {
    private int val;

    public int getNext() {
        return val++;
    }
}
