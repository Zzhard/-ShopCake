package day04.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/28 11:26 下午
 */
public class demoForWrite {
    private static String URL="jdbc:mysql://127.0.0.1:3306/java?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
    private static String USERNAME="root";
    private static String PASSWORD="Zxg568233";

    public static void modify(String sql, List<Object> params){
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement=conn.prepareStatement(sql);
        ) {
            for (int i = 0; i < params.size(); i++) {
                statement.setObject(i+1,params.get(i));
            }
            int effrow = statement.executeUpdate();
            System.out.println("effrow = " + effrow);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
