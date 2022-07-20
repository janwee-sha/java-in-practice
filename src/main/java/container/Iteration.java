package container;

import java.util.*;

public class Iteration {
    public static void main(String[] args) {
        List<String> al = new ArrayList<>(Arrays.asList("a b c d e f g h i j".split(" ")));
        List<String> ll = new LinkedList<>(al);

        System.out.println(al.removeIf("a"::equals) ? "some elements deleted." : "none of elements deleted.");

        al.listIterator().add("a1");

        printList(al);
        printList(ll);
    }

    private static void printList(List<String> list) {
        if (list instanceof RandomAccess) {
            //use random access algorithm
            System.out.println("random access to collection :");
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i)+",");
            }
            System.out.println();
        } else {
            //use sequential access algorithm
            System.out.println("sequential access to collection :");
            //java 8 style of iteration with lambda expression
            list.iterator().forEachRemaining(str->System.out.print(str+","));
            System.out.println();
        }
    }
}
