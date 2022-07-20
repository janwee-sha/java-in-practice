package concurrency.objectsharing;

import concurrency.annotation.ThreadSafe;

@ThreadSafe
public class SafeSequence {
    /**
     * val guarded by this
     */
    private int val;

    public synchronized int getNext() {
        return val++;
    }
}
