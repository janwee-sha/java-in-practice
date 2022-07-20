package stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class StreamFeatures {
    public static void main(String[] args) {
        //call Stream.of() to produce a stream
        print(Stream.of(0.01, 0.2, 9));

        //call Collections.stream() or Arrays.stream() to produce a stream
        print(Arrays.stream("i am janwee".split(" ")));

        Random rand=new Random(23);
        //print a IntStream
        print(rand.ints().boxed(),4);
        //set the boundary of numbers
        print(rand.ints(10,20).boxed(),5);
        //set the size of stream
        print(rand.ints(3).boxed(),5);
        //set the size of stream and the boundary of numbers
        print(rand.ints(3,10,20).boxed());
    }

    private static <T> void print(Stream<T> stream) {
        StringBuilder sb = new StringBuilder("[");
        stream.forEach(e -> sb.append(e).append(","));
        sb.deleteCharAt(sb.length() - 1).append("]");
        System.out.println(sb.toString());
    }

    private static <T> void print(Stream<T> stream,int limit){
        print(stream.limit(limit));
    }
}
