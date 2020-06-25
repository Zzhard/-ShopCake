package day04.jdbc;

import java.sql.*;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/28 11:45 下午
 */
public class quaryObject {
    private static String URL="jdbc:mysql://127.0.0.1:3306/java";
    private static String USERNAME="root";
    private static String PASSWORD="Zxg568233";
    public static void main(String[] args) {
        /**这种方式，如果需要查询多个类的时候，针对不同类都要写一个方法
         * 每个方法除了类名不一样，其他都一样
         * 可以使用泛型和反射封装一个方法，该方法兼容查询所有的类
         */
        //testQuaryUser();
        testQuaryAccount();

    }

    private static void testQuaryAccount() {
        String sql="select * from account";
        ResultSet resultSet=null;
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement=conn.prepareStatement(sql);
        ) {
            resultSet= statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("account_name");
                Accout accout = new Accout(id, name);
                System.out.println(accout.toString());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(null!=resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }


    }

    private static void testQuaryUser() {
        String sql="select * from user";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement=conn.prepareStatement(sql);
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                User user = new User(id, name, age);
                System.out.println(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
