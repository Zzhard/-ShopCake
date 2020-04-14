package day02.homewok.Topic4.newtopic;

/**
 * @Author zhaoxg
 * @Date 2020/4/14 23:59
 */
public class App {
    public static void main(String[] args) {
        Array<String> list=new DynamicArray<>();
        list.add("小黑");
        list.add("小黑");
        list.add("小黑");
        list.add("小黑");
        list.add("小黑");
        list.add("小黑");
        list.add("小黑");
        list.add("小黑");
        list.add("小黑");
        list.add("小黑");
        list.add("小黑");
        System.out.println(list.toString());
        System.out.println(list.getCapacity());
        System.out.println(list.getSize());
    }
}
