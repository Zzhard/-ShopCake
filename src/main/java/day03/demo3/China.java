package day03.demo3;

/**
 * @Author zhaoxg
 * @Date 2020/4/13 22:49
 */
public class China extends Person {
    public China(String type) {
        super("中国人");
    }

    public China() {
    }

    @Override
    public void say() {
        System.out.println("说中国话");
    }
}
