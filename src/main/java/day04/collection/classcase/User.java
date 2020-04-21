package day04.collection.classcase;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;

/**
 * @Author zhaoxg
 * @Date 2020/4/21 22:44
 */
@Getter
@Setter
@ToString
public class User {
    private String uid;
    private String name;
    private int age;
    private Map<String, List<String>> hobby;


    public User(String uid,String name) {
        this();
        this.uid=uid;
        this.name=name;
    }
    public User(String uid,String name,int age) {
        this(uid, name);
        this.age=age;
    }

    public User(){
        this.hobby=new HashMap<>();
    }
    public static User of(String uid,String name){
        return new User(uid,name);
    }
    public static User of(String  uid,String name,int age) {
        return new User(uid,name,age);
    }
    public User age(int age){
        this.age=age;
        return this;
    }

    public User hobby(String hobbyName,String hobby){
        if(this.hobby.containsKey(hobbyName)){
            this.hobby.get(hobbyName).add(hobby);
        }else {
            List<String> hobbys = new ArrayList<>();
            hobbys.add(hobby);
            this.hobby.put(hobbyName,hobbys);
        }
        return this;
    }
    public User hobby(String hobbyName,String...hobby){
        //数组转换成功集合
        List<String> hobbys = Arrays.asList(hobby);
        if(this.hobby.containsKey(hobbyName)){
            this.hobby.get(hobbyName).addAll(hobbys);
        }else {
            this.hobby.put(hobbyName,hobbys);
        }
        return this;
    }

}
