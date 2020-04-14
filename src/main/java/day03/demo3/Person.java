package day03.demo3;

/**
 * @Author zhaoxg
 * @Date 2020/4/13 22:40
 */
public abstract class Person {


    private String type;

    public abstract void say();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Person(String type) {
        this.type = type;
    }

    public Person() {
    }
}
