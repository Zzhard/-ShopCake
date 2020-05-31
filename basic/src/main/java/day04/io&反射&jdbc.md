#### IO

###### 读文件

+ 字符流

  + BufferReader

    ```java
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
                String s = null;
                while ((s = reader.readLine()) != null) {
                    System.out.println(s);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    ```

  + FilerReader

    ```jav
    try (FileReader reader = new FileReader(new File(path))) {
                int len;
                char[] chars=new char[256];
                StringBuilder builder=new StringBuilder();
                while ((len=reader.read(chars))!=-1){
                    String s=new String(chars,0,len);
                    builder.append(s);
                }
                System.out.println(builder.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    ```

    

+ 字节流

  + FileInputStream

    ```java
    File file = new File(path);
            //FileInputStream继承InputStream，InputStream则实现Closeable，所以可以自动关流
            try (FileInputStream fileInputStream=new FileInputStream(file)){
                int len;
                byte[] bytes=new byte[256];
                StringBuilder builder=new StringBuilder();
                while ((len=fileInputStream.read(bytes))!=-1){
                    String s=new String(bytes,0,len);
                    builder.append(s);
                }
                System.out.println(builder.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    ```

  + BufferInputStream

    ```java
    File file = new File(filepath);
            //FileInputStream继承InputStream，InputStream则实现Closeable，所以可以自动关流
            try (BufferedInputStream inputStream= new BufferedInputStream(new FileInputStream(file))) {
                int len;
                byte[] bytes = new byte[256];
                StringBuilder builder = new StringBuilder();
                while ((len = inputStream.read(bytes)) != -1) {
                    String s = new String(bytes, 0, len);
                    builder.append(s);
                }
                System.out.println(builder.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    ```

  ###### 写文件

  + 字符流

    + FileReader

      ```java
      try (FileWriter writer = new FileWriter(new File(path))) {
                  String str="hello world";
                  writer.write(str);
                  System.out.println("写文件操作完了");
              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              }
      ```

    + BufferReader

      ```java
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filepath)))) {
                  String str="java 世界最好语言";
                  writer.write(str);
                  System.out.println("写完了");
              } catch (IOException e) {
                  e.printStackTrace();
              }
      ```

  + 字节流

    + FileOutputStream

      ```java
      try (FileOutputStream outputStream = new FileOutputStream(new File(filepath))) {
                  String str="helllo";
                  byte[] bytes = str.getBytes();
                  outputStream.write(bytes,0,str.length());
                  System.out.println("写完了");
              } catch (FileNotFoundException e) {
      
              } catch (IOException e) {
                  e.printStackTrace();
              }
      ```

    + BufferOutputStream

      ```jav
      try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(path
              )))) {
                  String str="gogoogoo";
                  byte[] bytes = str.getBytes();
                  outputStream.write(bytes);
                  System.out.println("写完了");
              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              } catch (IOException e) {
                  e.printStackTrace();
              }
      ```

      

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


#### jdbc

+ 基本写法

```java
				String sql="select * from user";
        //try里面就不需要关流了
				//1、建立连接
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
```



+ 设计封装DDL

  ```java
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
  ```

+ 查询user表并将结果成实体

  + 方法一：

    ```java
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
    ```

    该方式存在的缺陷是，如果要查询Acount类，又要重新写一个方法，没有兼容，解决方法就是使用反射，方法支持查询所有的类

    ```
    public static <T> List<T> quary(String sql,Class<T> clazz){
            List<T> result= Lists.newArrayList();
            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                 PreparedStatement statement = conn.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()){
                		//类中必须写空参的构造方法
                    T instance = clazz.newInstance();
                    Field[] fields = clazz.getDeclaredFields();
                    for (Field field : fields) {
                        Object val = resultSet.getObject(field.getName());
                        field.setAccessible(true);
                        //类的属性和数据库中字段属性要一致，比如都是int，如果类型不一致，需要转换
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
    ```

    

