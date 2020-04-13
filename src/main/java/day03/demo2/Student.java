package day03.demo2;

import day02.oop.Person;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/4/13 6:37 下午
 */
public class Student extends Person {
    public static void main(String[] args) {
        Student student = new Student("小明", 18);
        student.setName("小明");
        System.out.println(student.getName());
    }

    public Student(String name, int age) {
        super(name, age);
        super.say();
    }
}
