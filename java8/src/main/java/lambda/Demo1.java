package lambda;

import java.util.Comparator;

/**
 * @Author zhaoxg
 * @Date 2020/5/24 9:52
 */
public class Demo1 {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (o1, o2) -> 1;
        int i = comparator.compare(1, 2);
        System.out.println("i = " + i);
        demo();
    }

    public static void demo(){
        Thread thread = new Thread(() -> System.out.println("哈哈线程"));

        thread.start();
    }
}
