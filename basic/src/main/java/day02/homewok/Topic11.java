package day02.homewok;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/4/19 3:24 下午
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作业11: I/O + 集合 + 对象 练习题
 *
 * 文件: 位置随意,数据格式: id, name, gender, score, address
 *
 * 读取出数据之后,放到对象中User
 *
 * 在将User放入集合中
 *
 * 集合中的User,按照address,gender,分组,且每个组内的分数还要排序
 *
 * - 如: 北京,男 ; 上海,女
 *
 *
 * -----------------------
 *
 * 原始问题: 文件位置随意,存储数据格式如下: id, name, age, gender; 读取之后 存入数据库!
 *
 * @author haoc
 */
public class Topic11 {


    public static void main(String[] args) {
        String str="/Users/xianggengzhao/Documents/JavaPro/java/ShopCake/src/main/java/day02/homewok/test.txt";
        //1.读取文件信息获取user list
        List<User> users = readFile(str);
        System.out.println(users);
        //2.按照性别进行分组
        Map<String, List<User>> map = groupByGender(users);
        System.out.println(map);
        //3.对分数进行排序
        Map<String, List<User>> listMap = sort(map);
        System.out.println(listMap);


    }
    //1、读取文件内容
    private static List<User> readFile(String path) {
        List<User> users=new ArrayList<>();
        File file = new File(path);
        //这种写法不需要手动关流
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String val=null;
            while ((val=reader.readLine())!=null){
                String[] split = val.split(",");
                int id=Integer.parseInt(split[0]);
                String name=split[1];
                int age=Integer.parseInt(split[2]);
                int score=Integer.parseInt(split[3]);
                String gender=split[4];
                User user = User.builder()
                        .id(id)
                        .name(name)
                        .age(age)
                        .score(score)
                        .gender(gender)
                        .build();
//                    User user = new User(id,name,age,score,gender);
                users.add(user);


            }
        } catch (Exception e) {
            throw new IllegalStateException(e);

        }

        return users;
    }

    //1、读文件,并获取List<User>  /Users/xianggengzhao/Documents/JavaPro/java/ShopCake/src/main/java/day02/homewok/test.txt
//    public static List<User> readFile(String path) {
//        List<User> users=new ArrayList<>();
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new FileReader(path));
//            String val;
//            while ((val=reader.readLine())!=null){
//                String[] split = val.split(",");
//                User user = new User();
//                user.setId(Integer.parseInt(split[0]));
//                user.setName(split[1]);
//                user.setAge(Integer.parseInt(split[2]));
//                user.setScore(Integer.parseInt(split[3]));
//                user.setGender(split[4]);
//                users.add(user);
//
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return users;
//    }

    //2、读文件、获取List<User>简洁写法
    //2、按照性别进行分组
    private static Map<String,List<User>> groupByGender(List<User> users){
        Map<String,List<User>> map=new HashMap<>();
        for (User user : users) {
            String gender = user.getGender();
            if(map.containsKey(gender)){
                map.get(gender).add(user);
            }else {
                List<User> userList=new ArrayList<>();
                userList.add(user);
                map.put(gender,userList);
            }

        }
        return map;

    }

    //3、按分数进行排序，升序排序

    private static Map<String,List<User>> sort(Map<String,List<User>> map){
        for (Map.Entry<String, List<User>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<User> users = entry.getValue();
            for (int i=0;i<users.size();i++) {
                for (int j = 0; j <i ; j++) {
                    User u1 = users.get(i);
                    User u2= users.get(j);
                    if(u1.getScore()>u2.getScore()){
                       users.set(i,u2);
                       users.set(j,u1);
                    }

                }

            }
        }

        return map;

    }



}
