package day04.collection.classcase;

/**
 * @Author zhaoxg
 * @Date 2020/4/22 22:56
 */

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 生成50个0-9999数，不能重复
 */
public class case4 {
    public static void main(String[] args) {
        demo1();
        demo2();
        Set<Integer> set=new HashSet<>();
        set.add(2);
        set.add(2);
        System.out.println(set+"====="+set.size());
    }

    //感觉这种写法有问题？如果生成的数在set已存在肯定add不进去，集合长度达不到50
    private static void demo2() {
        Random random = new Random();
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<50;i++){
            int num = random.nextInt(9999);
            set.add(num);
        }
        System.out.println(set.size());
//        set.forEach(System.out::println);
        System.out.println(set);

    }

    private static void demo1() {
        Set<Integer> set = new HashSet<>();
        Random random = new Random();
        while (set.size()<50){
            set.add(random.nextInt(9999));
        }
        System.out.println(set.size());
        System.out.println(set);

    }
}
