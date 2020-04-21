package day02.homewok;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/4/13 4:56 下午
 */

import java.util.*;

/**
 * 作业10: 集合作业(需要提前学习下 List,Map等基本用法)
 *
 * - 定义一个对象,User,属性有 name,age,score,gender
 *
 * - 使用集合ArrayList,来装一批User, 数据可以随意
 *
 * - 要求1: 遍历集合,打印所有内部数据
 *
 * - 要求2: 按照年纪(age)进行分组,比如23岁,有3个人, 24岁有5个人,
 *
 * - 要求3: 按照分数(score)范围分组, 比如 60-70, 有一组人, 70-80有一组人
 *
 * - 要求4: 基于分数排序, 由高到低
 *
 * - 要求5: 基于性别分组,求男同学的平均分,求女同学的平均分
 *
 * @author haoc
 */
public class Topic10 {


    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User().of("小明",20,80,"男"));
        list.add(new User().of("小红",20,70,"男"));
        list.add(new User().of("小黑",23,60,"男"));
        list.add(new User().of("小白",40,80,"男"));
        list.add(new User().of("小蓝",40,60,"男"));
        groupByage(list);
//        printOut(list);
        groupByscore(list);
    }
    //1、遍历List,打印list中元素
    public static void printOut(List<User> list){
        for (User user:list){
            System.out.println(user);
        }
    }
    //2、按照年龄进行分组
    public static void groupByage(List<User> list){
        Map<Integer,List<User>> map=new HashMap<>();
        for (User user:list){
            int age = user.getAge();
            if(map.containsKey(age)){
                map.get(age).add(user);

            }else {
                List<User> userlist=new ArrayList<>();
                userlist.add(user);
                map.put(age,userlist);
            }

        }
        System.out.println(map);

    }
    //3、按照分数进行分组

    public static void groupByscore(List<User> list){
        Map<String,List<User>> map=new HashMap<>();
        for (User user : list) {
            int score = user.getScore();
            if(score>=60&&score<70){
                String key="及格";
                if(map.containsKey(key)){
                    map.get(key).add(user);
                }
                else {
                    List<User> userList=new ArrayList<>();
                    userList.add(user);
                    map.put(key,userList);
                }
            }
            if(score>=70&&score<80){
                String key="良";
                if(map.containsKey(key)){
                    map.get(key).add(user);
                }
                else {
                    List<User> userList=new ArrayList<>();
                    userList.add(user);
                    map.put(key,userList);
                }
            }
            if(score>=90){
                String key="优";
                if(map.containsKey(key)){
                    map.get(key).add(user);
                }
                else {
                    List<User> userList=new ArrayList<>();
                    userList.add(user);
                    map.put(key,userList);
                }
            }

        }
        System.out.println(map);

    }

    //4、基于分数进行排序，由高到低

    public static List<User>  sortByscore(List<User> list){
        List<User> userList=new ArrayList<>();
        List<Integer> scores=new ArrayList<>();
        Map<Integer,List<User>> map=new HashMap<>();
        for (User user : list) {
            int score = user.getScore();
            scores.add(score);
            if(map.containsKey(score)){
                map.get(score).add(user);
            }else {
                List<User> users=new ArrayList<>();
                users.add(user);
                map.put(score,users);
            }
            }
        for(Map.Entry<Integer,List<User>> entry:map.entrySet()){
            entry.getKey();
            for (int i = 0; i <map.size() ; i++) {
                for (int j=0;j<i;j++){

                }
            }

        }



    }


}


