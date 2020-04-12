package day03.demo1;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/4/9 6:51 下午
 */
public class Person {
    /**
     * 封装：1、权限修饰符，修饰类，方法，属性
     * public 公开的，不是同一个类，包都可以访问
     * protected 受保护的，只有一个体系，继承时子类可以访问
     * private 私有的，都不可以访问
     * 默认的
     */
    private String name;

    public int age;

    protected  String hobby;

    String sex;

    /**
     * 封装：getter和setter方法
     * @return
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
