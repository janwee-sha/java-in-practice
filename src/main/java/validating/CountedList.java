package validating;

import java.util.ArrayList;

public class CountedList extends ArrayList<String> {
    private static int count = 0;
    private int id = count++;

    public CountedList() {
        System.out.println("CountedList#" + id);
    }

    public int getId() {
        return id;
    }
}
