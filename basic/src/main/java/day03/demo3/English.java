package day03.demo3;

/**
 * @Author zhaoxg
 * @Date 2020/4/13 22:51
 */
public class English extends Person {
    public English(String type) {
        super("英国人");
    }

    public English() {
    }

    @Override
    public void say() {
        System.out.println("讲英文");
    }
}
