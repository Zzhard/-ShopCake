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
                .hobby("音乐", "古典","流行");
        User u3 = User.of("u003", "小绿").age(35)
                .hobby("文学", "西游记","金瓶梅")
                .hobby("音乐", "古典","流行");
        Map<String, User> map=new HashMap<>();

        Map<String, List<User>> listMap = groupByage(map);
        System.out.println(listMap);
        printOut(listMap);
    }

    private static Map<String, List<User>> groupByage(Map<String, List<User>> map) {
        Map<String, List<User>> hashMap = new HashMap<>();
        for (Map.Entry<String, List<User>> entry : map.entrySet()) {
            List<User> users = entry.getValue();
            for (User user : users) {
                int age = user.getAge();
                if(age<20){
                    if(hashMap.containsKey("青年")){
                        hashMap.get("青年").add(user);
                    }else {
                        List<User> userList=new ArrayList<>();
                        hashMap.put("青年",userList);
                    }
                }
                else if(age>20&&age<30){
                    if(hashMap.containsKey("中年")){
                        hashMap.get("中年").add(user);
                    }else {
                        List<User> userList=new ArrayList<>();
                        hashMap.put("中年",userList);
                    }
                }
                else if(age>30){
                    if(hashMap.containsKey("老年")){
                        hashMap.get("老年").add(user);
                    }else {
                        List<User> userList=new ArrayList<>();
                        hashMap.put("老年",userList);
                    }
                }
            }
        }
        return hashMap;
        
    }
    private static void printOut(Map<String, List<User>> map){
        for (Map.Entry<String, List<User>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<User> users = entry.getValue();
            for (User user : users) {
                System.out.println(key+"="+user);
            }
        }
        
    }
}
