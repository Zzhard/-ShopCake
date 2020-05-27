#### IO

+ 字符流

+ 字节流

  

#### 反射

+ 反射获取类的属性、方法等

  ```java
   Class<User> userClass = User.class;
          //获取类属性
          Field[] fields = userClass.getDeclaredFields();
          for (Field field : fields) {
              //每个属性的名字
              System.out.println("field = " + field.getName());
              //获取属性类型名字
                          System.out.println("field.getType().getName() = " + field.getType().getName());
  
          }
  		//获取类中方法
  		Method[] methods = userClass.getDeclaredMethods();
  		//获取类中的构造方法
  		Constructor<?>[] constructors = userClass.getConstructors();
  ```

  

+ 反射的用处：测试接口自动生成接口需要的参数

  ```java
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
  //User2类
  public class User2 {
      private String name1;
      private String name2;
      private String name3;
      private String name4;
      private String name5;
  
      public void setName1(String name1) {
          this.name1 = name1;
      }
  
      public void setName2(String name2) {
          this.name2 = name2;
      }
  
      public void setName3(String name3) {
          this.name3 = name3;
      }
  
      public void setName4(String name4) {
          this.name4 = name4;
      }
  
      public void setName5(String name5) {
          this.name5 = name5;
      }
  }
  //UserService
  public class UserService {
      public void createUser(User2 user){
          System.out.println(user);
      }
  }
  ```

  