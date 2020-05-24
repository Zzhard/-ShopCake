package day04.generic;

/**
 * @Author zhaoxg
 * @Date 2020/5/6 21:44
 */
public class LocalPairApp {
    public static void main(String[] args) {
        //编译的时候代码并没有报错，但是运行时会报错，因为foo2返回的两个值中有一个时Integer
        LocalPair pair = foo2();
        String val1 =(String) pair.getVal1();
        String val2 =(String) pair.getVal2();
        String[] strings = val1.split(",");
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings);
        }


    }
    //LocalPair类的两个属性时object类型
    private static LocalPair foo1() {
        LocalPair pair = new LocalPair("abc,bcd","efg,hij");
        return pair;
    }
    private static LocalPair foo2(){
        LocalPair pair = new LocalPair(123, "abc,dj");
        return pair;
    }
    private static LocalPair2<String,String> foo3(){
        LocalPair2<String, String> pair2 = new LocalPair2<>("abc", "bcd");
        return pair2;
    }
    private static LocalPair2<Integer,String> foo4(){
        LocalPair2<Integer, String> pair2 = new LocalPair2<>(123, "bcd");
        return pair2;
    }
}
