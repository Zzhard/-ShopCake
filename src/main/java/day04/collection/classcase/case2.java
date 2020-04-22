package day04.collection.classcase;

/**
 * @Author zhaoxg
 * @Date 2020/4/21 23:36
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对case1中年龄进行分组
 *   20以下为青年，20到30为中年，30以上为老年
 *   遍历出每个组中所有的人
 */
public class case2 {
    public static void main(String[] args) {
        User u1 = User.of("u001", "小明").age(18)
                .hobby("文学", "西游记","金瓶梅")
                .hobby("音乐", "古典","流行");
        User u2 = User.of("u002", "小红").age(25)
                .hobby("文学", "西游记","金瓶梅")
                .hobby("打游戏", "古典","流行");
        User u3 = User.of("u003", "小绿").age(35)
                .hobby("旅游", "西游记","金瓶梅")
                .hobby("打游戏", "古典","流行");
        User u4 = User.of("u003", "小绿").age(35)
                .hobby("旅游", "西游记","金瓶梅")
                .hobby("音乐", "古典","流行");
        Map<String, User> map=new HashMap<>();
        map.put(u1.getUid(),u1);
        map.put(u2.getUid(),u2);
        map.put(u3.getUid(),u3);
        map.put(u4.getUid(),u4);
//        Map<String, List<User>> listMap = groupByage(map);
//        printOut(listMap);
        Map<String, List<User>> map1 = groupByhobby(map);
        printOut(map1);
    }

    //根据年龄进行分组
    private static Map<String, List<User>> groupByage(Map<String, User> map) {
        Map<String, List<User>> hashMap = new HashMap<>();
        for (Map.Entry<String, User> entry : map.entrySet()) {
            User user = entry.getValue();
            int age = user.getAge();
            System.out.println(age);
            if(age<20){
                if(hashMap.containsKey("青年")){
                    hashMap.get("青年").add(user);
                }else {
                    List<User> userList=new ArrayList<>();
                    userList.add(user);
                    hashMap.put("青年",userList);
                }
            }
            else if(age>20&&age<30){
                if(hashMap.containsKey("中年")){
                    hashMap.get("中年").add(user);
                }else {
                    List<User> userList=new ArrayList<>();
                    userList.add(user);
                    hashMap.put("中年",userList);
                }
            }
            else if(age>30){
                if(hashMap.containsKey("老年")){
                    hashMap.get("老年").add(user);
                }else {
                    List<User> userList=new ArrayList<>();
                    userList.add(user);
                    hashMap.put("老年",userList);
                }
            }
        }
        return hashMap;
        
    }
    private static void printOut(Map<String, List<User>> map){
        for (Map.Entry<String, List<User>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<User> users = entry.getValue();
            System.out.println(key+"="+users);
        }
        
    }
    //根据爱好进行分组
    private static Map<String,List<User>> groupByhobby(Map<String, User> map){
        Map<String,List<User>> newMap=new HashMap<>();
        for (Map.Entry<String, User> entry : map.entrySet()) {
            User user = entry.getValue();
            Map<String, List<String>> hobby = user.getHobby();
            for (Map.Entry<String, List<String>> hobbys : hobby.entrySet()) {
                String key = hobbys.getKey();
                if(newMap.containsKey(key)){
                    newMap.get(key).add(user);
                }else {
                    List<User> users=new ArrayList<>();
                    users.add(user);
                    newMap.put(key,users);
                }

            }
        }
        return newMap;
    }
}
