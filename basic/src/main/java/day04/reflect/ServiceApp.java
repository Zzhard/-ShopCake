package day04.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author zhaoxg
 * @Date 2020/5/8 21:45
 */
public class ServiceApp {
//    public static void main(String[] args) {
//        User2 user2 = new User2();
//        user2.setName1("1");
//        user2.setName2("2");
//        user2.setName3("3");
//        //测试这个接口需要User2对象，并对它属性一个个的设置值，看起来比较麻烦
//        new UserService().createUser(user2);
//    }
public static void main(String[] args) throws Exception {
    //1、比如开发给一个字符串接口，通过拆解，获取到对应的类day04.reflect.UserService
    String service="day04.reflect.UserService#createUser";
    //2、获取类对象
    Class<?> name = Class.forName("day04.reflect.UserService");
    //3、获取类中方法
    Method[] methods = name.getDeclaredMethods();
    for (Method method : methods) {
        if(method.getName().equals("createUser")){
            //4、获取方法中形参类型，User2
            Class<?>[] parameterTypes = method.getParameterTypes();
            Class<?> type = parameterTypes[0];
            System.out.println("type = " + type.getName());
            //5、获取User2中的属性
            Field[] fields = type.getDeclaredFields();
            for (Field field : fields) {
                //6、拿到属性名和类型之后，对每个属性进行数据构造
                System.out.println("field.getName() = " + field.getName());
            }


        }

    }

}
}
