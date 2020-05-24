package lambda;

import java.util.Date;
import java.util.Map;

/**
 * @Author zhaoxg
 * @Date 2020/5/24 11:04
 */
public class Demo3 {
    public static void main(String[] args) {
        foo foo = (i1, time, map) -> "hello";

    }
     interface foo{
        String foo(Integer i1, Date time, Map<String,String> map);
     }
}
