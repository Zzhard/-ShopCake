package day02.oop;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/4/9 3:03 下午
 */
public class Person {
    private String name;

    private float heigh;

    private int age;
    private String hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeigh() {
        return heigh;
    }

    public void setHeigh(float heigh) {
        this.heigh = heigh;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void say(){
        System.out.println("会说话");
    }
    public void walk(){
        System.out.println("会走路");
    }
}
