package day04.jdbc;

import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.List;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/29 10:00 上午
 */
public class quaryClass {
    private static String URL="jdbc:mysql://127.0.0.1:3306/java";
    private static String USERNAME="root";
    private static String PASSWORD="Zxg568233";
    //使用反射，兼容查询所有的类，不需要每个类写一种方法
    public static <T> List<T> quary(String sql,Class<T> clazz){
        List<T> result= Lists.newArrayList();
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();
        ) {
            while (resultSet.next()){
                T instance = clazz.newInstance();
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    Object val = resultSet.getObject(field.getName());
                    field.setAccessible(true);
                    field.set(instance,val);
                }
                result.add(instance);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    return result;
    }
}
