package day03.demo3;

/**
 * @Author zhaoxg
 * @Date 2020/4/13 22:53
 */
public class App {
    public static void main(String[] args) {
        Person china = new China();
        talk(china);
        English english = new English();
        talk(english);


    }

    public static void talk(Person person){
        person.say();
    }
}
