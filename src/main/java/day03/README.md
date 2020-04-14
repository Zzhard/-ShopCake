####       面向对象三大特性

+ 封装

+ 继承

+ 多态

  ```java
  public class App {
  
    public static void main(String[] args) {
      // Car car = new Car("", "");
  
      /**
       * 体现多态的写法,是下面的run方法, run方法在面向的是一个抽象的Car
       *
       * 在run方法看来, 它只看Car,这个抽象的东西, 具体是宝马, 还是奔驰, run不在乎
       */
      Car car1 = new Bmw();
  
      Car car2 = new Benz();
  
      Car car3 = new George();
  
      run(car1);
    }
  
    /**
     * 马路在跑车
     */
    private static void run(Car car) {
        //instanceof关键字在反射中会使用到
      if (car instanceof George) {
        System.out.println("不行不行,太大了");
        return;
      }
      System.out.println("马路在跑" + car.getBrand() + "车");
    }
  }
  
  ```

  #### 抽象类

  ##### 1、语法

  ```java
  //抽象类Person
  package shopee.cn.com.day03.demo3;
  
  /**
   * @Author zhaoxg
   * @Date 2020/2/19 9:01
   * 1、抽象类,不能被new
   * 2、抽象类中的抽象方法不能有方法体，不能实现
   * 3、子类继承抽象类时候必须实现抽象方法(重写)
   */
  public abstract class Person {
      private String type;
      /**
       * 不能有方法体，不能实现这个方法
       */
      public abstract  void talk();
  
      public Person(String type){
          this.type=type;
      }
  
      public String getType() {
          return type;
      }
  
      public void setType(String type) {
          this.type = type;
      }
  }
  
  //子类China
  package shopee.cn.com.day03.demo3;
  
  /**
   * @Author zhaoxg
   * @Date 2020/2/19 9:07
   */
  public class China extends Person {
      public China(){
          super("中国人");
      }
      @Override
      public void talk() {
          System.out.println("说中国话");
      }
  }
  //子类English
  package shopee.cn.com.day03.demo3;
  
  /**
   * @Author zhaoxg
   * @Date 2020/2/19 9:07
   */
  public class English extends Person {
      public English(String type) {
          super("英国人");
      }
      @Override
      public void talk() {
          System.out.println("讲英文");
      }
  }
  //App
  package shopee.cn.com.day03.demo3;
  
  /**
   * @Author zhaoxg
   * @Date 2020/2/19 9:09
   */
  public class App {
      public static void main(String[] args) {
          Person china=new China();
          Person english=new China();
          speak(china);
      }
      //speak方法面向的抽象类，具体对象它不管
      public static void speak(Person person){
          //调用抽象方法
          person.talk();
      }
  }
  ```

  ##### 2、面向模板编程（抽象类规定了抽象的方法，具体怎么实现由子类自己决定；抽象类给出共同的东西，相当一个模板; 单继承）

  ```java
  package shopee.cn.com.day03.demo5;
  
  /**
   * @Author zhaoxg
   * @Date 2020/2/20 8:19
   */
  public abstract class Person {
      public void open(){
          System.out.println("拿起电话");
      }
      public abstract void sayHello();
      public abstract void talk();
      public abstract void sayBye();
      
      public void close(){
          System.out.println("挂电话");
      }
      /**
       * 打电话的流程：人都有一个共同的模板，如下步骤
       * 1、每个人都需要拿起电话，所以这个方法不进行抽象
       * 2、具体电话内容抽象化，让每个子类自己去实现
       * 3、每个人都需要挂电话，所以这份不进行抽象
       */
      public void call(){
          open();
          sayHello();
          talk();
          sayBye();
          close();
      }
  }
  
  ```

  

  #### 接口

  ##### 1、语法

  ```java
  //Person接口
  /**
   * @Author zhaoxg
   * @Date 2020/2/20 7:40
   * 接口的定义方式:interface关键字，不能实例化
   */
  public interface Person{
      /**
       * 普通类的定义方法:  public void talk(){}
       * 抽象类的定义方法:  protected abstract  void talk();
       * 接口定义:         void talk()
       */
      void talk();
  }
  //communication接口  
  /**
   * @Author zhaoxg
   * @Date 2020/2/20 7:46
   */
  public interface Communication {
  
  }
  //stu 类实现这两个接口
  
  /**
   * 子类通过implements关键字实现接口，并重写接口的方法
   * 可以实现多个接口，多个接口直接用逗号隔开
   * @Author zhaoxg
   * @Date 2020/2/20 7:44
   */
  public class Stu implements Person,Communication {
      @Override
      public void talk() {
          System.out.println("stu talk");
      }
  }
  //Tea实现这两个接口
  
  /**
   * @Author zhaoxg
   * @Date 2020/2/20 7:50
   */
  public class Teat implements Person {
      @Override
      public void talk() {
          System.out.println(" Tea talk");
      }
  }
  //App
  
  /**
   * @Author zhaoxg
   * @Date 2020/2/20 7:51
   */
  public class App {
      public static void main(String[] args) {
          Person stu=new Stu();
          Person tea=new Stu();
          speak(stu);
      }
      private static void speak(Person person) {
          person.talk();
      }
  }
  ```

  ##### 2、面向规范编程（直观而言就是接口是类需要拓展存在，比如有的人由文学修养，有的人有音乐修养，那么可以把文学修养和音乐修养作为接口，谁有这个能力谁就去实现它们的方法）

  ```java
  //文学修养接口
  package shopee.cn.com.day03.demo6;
  
  /**
   * @Author zhaoxg
   * @Date 2020/2/20 8:36
   */
  public interface 文学修养  {
  
      void readBook();
  }
  //音乐修养接口
  
  /**
   * @Author zhaoxg
   * @Date 2020/2/20 8:38
   */
  public interface 音乐修养  {
       void sing();
  }
  //Person抽象类package shopee.cn.com.day03.demo6;
  
  /**
   * @Author zhaoxg
   * @Date 2020/2/20 8:42
   */
  public abstract class Person  {
      public void towLegs(){
          System.out.println("每个人都有两条腿");
      }
      //每个人都会讲话，但是你讲的什么话由你自己实现
      protected abstract void talk();
  }
  //Poet类
  
  /**诗人可以同时实现两个接口
   * @Author zhaoxg
   * @Date 2020/2/20 8:46
   */
  public class Poet extends Person implements 文学修养,音乐修养 {
      @Override
      protected void talk() {
          System.out.println("poet talk");
      }
  
      @Override
      public void readBook() {
          System.out.println("品三国");
      }
  
      @Override
      public void sing() {
          System.out.println("是世界级音乐家");
      }
  }
  //Stu类
  
  /**
   * @Author zhaoxg
   * @Date 2020/2/20 8:39
   */
  public class Stu extends Person implements 文学修养 {
  
      @Override
      protected void talk() {
          System.out.println(" stu talk");
      }
  
      @Override
      public void readBook() {
          System.out.println("三国演义");
      }
  
  }
  ```

#### static关键字

``` java
/**
 * @Author zhaoxg
 * @Date 2020/2/20 9:08
 */
public class Person {
    private String name;
    /**
     * 类属性
     *
     *
     */
    private static String age;
    /**
     * 常量
     */
    private static final int COUNT=1024;

    /**
     * 静态代码块
     */
    static {
        System.out.println(" static class init");
    }

    public void say(){
        System.out.println("say hello");
    }

    /**
     * 静态方法
     */
    public static void sing(){
        System.out.println("sing song");
    }
}
```

#### 异常处理

#### 泛型