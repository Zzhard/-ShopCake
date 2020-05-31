package day04.jdbc;

import java.sql.*;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/28 9:59 上午
 */
public class demo1 {
    private static String URL="jdbc:mysql://127.0.0.1:3306/java";
    private static String USERNAME="root";
    private static String PASSWORD="Zxg568233";


    public static void main(String[] args) {
        String sql="select * from user";
        //try里面就不需要关流了
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            PreparedStatement statement = connection.prepareStatement(sql);) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String id = resultSet.getString("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("id="+id+",username="+username+",password="+password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
