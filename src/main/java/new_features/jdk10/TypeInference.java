package new_features.jdk10;

import java.util.ArrayList;

/**
 * 局部变量类型推断是 Java 10 中最值得开发人员注意的新特性，
 * 允许省略通常不必要的局部变量类型初始化声明。
 */
public class TypeInference {
    public static void main(String[] args) {
        var list = new ArrayList<String>();
        list.add("Hello, ");
        list.add("Java 10.");
        for (var e : list) {
            System.out.print(e);
        }
    }
}
