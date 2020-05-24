package day04.generic;

import org.apache.commons.lang3.tuple.Pair;

/**
 * @Author zhaoxg
 * @Date 2020/5/6 22:36
 */
public class CommonPair {
    public static void main(String[] args) {
        //方法需要返回两个值，可以直接用Pair
        Pair<String, String> pair = Pair.of("abc", "bcd");
        //getKey()和getLeft()一样
        pair.getKey();
        System.out.println("pair.getLeft() = " + pair.getLeft());

        pair.getValue();
        System.out.println("pair.getRight() = " + pair.getRight());

    }
}
