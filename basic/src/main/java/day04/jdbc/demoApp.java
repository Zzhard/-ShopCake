package day04.jdbc;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/28 11:32 下午
 */
public class demoApp {
    public static void main(String[] args) {
        //testInsert();
        testUpdate();
    }

    private static void testUpdate() {
        String sql="update user set username=? where id =?";
        List<Object> list=Lists.newArrayList("六六",4);
        demoForWrite.modify(sql,list);
    }

    private static void testInsert() {
        String sql="insert into user values(?,?,?,?)";
        List<Object> list= Lists.newArrayList();
        list.add(4);
        list.add("张三");
        list.add("12345");
        list.add("999");
        demoForWrite.modify(sql,list);
    }
}
