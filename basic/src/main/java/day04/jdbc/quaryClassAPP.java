package day04.jdbc;

import java.util.List;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/29 11:40 下午
 */
public class quaryClassAPP {
    public static void main(String[] args) {
        String sql="select * from user";
        List<User> users = quaryClass.quary(sql, User.class);
        for (User user : users) {
            System.out.println("user = " + user);

        }
    }
}
