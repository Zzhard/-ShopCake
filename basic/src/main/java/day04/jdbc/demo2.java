package day04.jdbc;

import java.sql.*;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/28 10:47 下午
 */
public class demo2 {
    private static String URL="jdbc:mysql://127.0.0.1:3306/java?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
    private static String USERNAME="root";
    private static String PASSWORD="Zxg568233";
    public static void main(String[] args) {
        //testInsert();
        //testUpdate();
        testDelete();
    }

    private static void testDelete() {
        String sql="delete from user where id=?";
        try (Connection  conn = DriverManager.getConnection(URL, USERNAME, PASSWORD) ;
            PreparedStatement statement=conn.prepareStatement(sql)){
            statement.setInt(1,4);
            int efferow = statement.executeUpdate();
            System.out.println("efferow = " + efferow);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testUpdate() {
        Connection conn=null;
        PreparedStatement statement=null;
        String sql="update user set username=? where id=?";
        try {
            conn=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            statement=conn.prepareStatement(sql);
            statement.setString(1,"张三");
            statement.setInt(2,4);
            int effectrow = statement.executeUpdate();
            System.out.println("effectrow = " + effectrow);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(null!=statement){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=conn){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void testInsert() {
        String sql="insert into user values(?,?,?,?)";
        Connection conn=null;
        PreparedStatement statement=null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = conn.prepareStatement(sql);
            statement.setInt(1,4);
            statement.setString(2,"王五");
            statement.setString(3,"12345");
            statement.setString(4,"9999");
            int effrow = statement.executeUpdate();
            System.out.println("effrow = " + effrow);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(null!=statement) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=conn){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
