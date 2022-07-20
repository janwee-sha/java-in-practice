package array.test;

import array.ParameterizedArray;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParameterizedArrayTest {
    @BeforeAll
    static void beforeAllMsg() {
        System.out.println(">>> Starting ParameterizedArrayTest");
    }

    @AfterAll
    static void afterAllMsg() {
        System.out.println(">>> Finished ParameterizedArrayTest");
    }

    @SuppressWarnings("unchecked")
    @Test
    public void parameterType() {
        System.out.println("Running testParameterType()");
        Integer[] ints = {1, 2, 3};
        Integer[] ints2 = new ParameterizedArray.ClassParameter<Integer>().f(ints);
        ints2 = ParameterizedArray.MethodParameter.f(ints);
        System.out.println(Arrays.toString(ints2));

        List<String>[] ls = (List<String>[]) new ArrayList[10];
        for (int i = 0; i < ls.length; i++) {
            List intList = new ArrayList();
            intList.add(i);//add a ArrayList<Integer> into ArrayList<String>
            ls[i] = intList;
        }
        System.out.println(Arrays.toString(ls));
        System.out.println(new ArrayList<>(10));
    }
}
