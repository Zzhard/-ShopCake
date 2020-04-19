package day02.homewok;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/4/13 4:58 下午
 */

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 定义一个对象,User,属性有 name,age,score,gender
 */
@Getter
@Setter
@Builder
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private Integer score;
    private String gender;

    public User of(Integer id,String name,Integer age,Integer score,String gender){
       return new User(id,name,age,score,gender);
    }

    public User(Integer id,String name, Integer age, Integer score, String gender) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.gender = gender;
        this.id=id;
    }
    public User(){

    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                ", gender='" + gender + '\'' +
                '}';
    }
}
