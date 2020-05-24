package lambda;

/**
 * @Author zhaoxg
 * @Date 2020/5/24 11:17
 */

import java.util.function.Consumer;
import java.util.function.Function;

/**
 *     函数式接口类型：
 *     转换型：Function<T, R>
 *     消费型：Consumer<T>
 *     供给型：Supplier<T>
 *     断言型：
 *
 */
public class Demo4 {
    public static void main(String[] args) {
        testConsumer();


    }



    public static void testConsumer(){
        Consumer<String> consumer=str -> {

            int length = str.length();
            System.out.println("length = " + length);
        };
        consumer.accept("hello ketty");

    }

    public static void testFunction(){
        Function<String,String> func=s -> s.toUpperCase();
        String apply = func.apply("hello");
        System.out.println("apply = " + apply);

    }
}
