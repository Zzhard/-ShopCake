package day04.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author zhaoxg
 * @Date 2020/5/7 22:42
 */
public class UserApp {
    public static void main(String[] args) {
//        testGetmethod();
//        testGetCustrut();
        testGetMethods();
    }

    private static void testGetFields() {
        Class<User> userClass = User.class;
        //获取类属性
        Field[] fields = userClass.getDeclaredFields();
        for (Field field : fields) {
            //每个属性的名字
            System.out.println("field = " + field.getName());
            //获取属性类型名字
            System.out.println("field.getType().getName() = " + field.getType().getName());
        }
    }

    private static void testGetCustrut(){
        Class<User> userClass = User.class;
        //获取构造方法
        Constructor<?>[] constructors = userClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor = " + constructor.getName());
            //获取构造方法中的参数类型
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("parameterType.getName() = " + parameterType.getName());
            }
        }
    }

    private static void testGetMethods(){
        Class<User> userClass = User.class;
        //获取类中所有的方法
        Method[] methods = userClass.getDeclaredMethods();
        for (Method method : methods) {
//            System.out.println("method.getName() = " + method.getName());
            //获取方法中参数类型
            if(method.getName().equals("say")){
                //获取类中的方法
                Class<?>[] types = method.getParameterTypes();
                for (Class<?> type : types) {
                    System.out.println("type = " + type.getName());
                }
                //获取跑异常的方法
                Class<?>[] types1 = method.getExceptionTypes();
                for (Class<?> aClass : types1) {
                    System.out.println("aClass = " + aClass.getName());
                }

            }
        }
    }
}
