package day03.demo4;

/**
 * @Author zhaoxg
 * @Date 2020/4/13 23:10
 */
public class App {
    public static void main(String[] args) {
        Stu stu = new Stu();
        doSome(stu);

    }

    public static void doSome(Person person){
        person.talk();
    }
}
