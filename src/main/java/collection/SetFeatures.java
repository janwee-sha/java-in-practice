package collection;

import java.util.HashSet;
import java.util.Set;

public class SetFeatures {
    public static void main(String[] args) {
        Set<String> colors;
//        colors= new TreeSet<>();
        colors = new HashSet<>();
//        colors=new LinkedHashSet<>();
        for (int i = 0; i < 100; i++) {
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Red");
            colors.add("Red");
            colors.add("Orange");
            colors.add("Yellow");
            colors.add("Blue");
            colors.add("Purple");
        }
        System.out.println(colors);
    }
}
