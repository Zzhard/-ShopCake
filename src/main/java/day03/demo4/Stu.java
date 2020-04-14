package day03.demo4;

/**
 * @Author zhaoxg
 * @Date 2020/4/13 23:08
 */
public class Stu implements Person,Music {
    @Override
    public void sing() {
        System.out.println("我会唱歌");
    }

    @Override
    public void talk() {
        System.out.println("我要上课");

    }
}
