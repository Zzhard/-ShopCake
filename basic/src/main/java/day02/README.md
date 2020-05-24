#### 流程控制

+ If  else的使用

  ```java
  /**
       * 猜数字
       * @param args
       */
      public static void main(String[] args) {
          int num=(int)(Math.random()*100);
          Scanner scanner = new Scanner(System.in);
          while (scanner.hasNext()){
              int i = scanner.nextInt();
              if(i==num){
                  System.out.println("哈哈，恭喜你猜对了");
                  break;
              }else if(i<num){
                  System.out.println("小了，继续猜");
              }else if(i>num){
                  System.out.println("大了");
              }else {
                  System.out.println(String.format("%s输入的数据有问题", num));
              }
          }
      }
  ```

  

+ Switch case

  ``` java
  /**
       * break关键字，匹配到case时才会跳出switch
       *
       * default关键字作为兜底
       *
       * 可以作为switch表达式数据：byte,short,char,int,枚举，string
       */
      @Test
      public void case1(){
          String str="hello0";
          switch (str){
              case "hello":
                  System.out.println("how do you do");
                  break;
              case "goodbye":
                  System.out.println("goodbye");
              default:
                  System.out.println("我不懂你说啥");
          }
      }
      /**
       * 一般业务代码处理，是多个常量进行相同的处理
       */
      @Test
      public void case2(){
          //        int type=1,支付宝，
          //        int type=2,微信，
          //        int type=3,京东，
          //        int type=4,易宝，
          int type=4;
          switch (type){
              case 1:
              case 2:
              case 3:
              case 4:
                  System.out.println("互联网支付");
                  break;
              case 6:
              case 7:
              case 8:
                  System.out.println("非互联网支付");
                  break;
              default:
                  System.out.println("出错了，不支持支付类型");
          }   
      }
  ```

+  for循环

+ while 、do....while循环

  ```jade
  /**
       * while用法
       */
      @Test
      public void case1(){
          int num=0;
          while (num<9){
              num++;
              System.out.println(num);
          }
      }
      /**
       * do while的用法
       */
      @Test
      public void case2(){
          int num=0;
          do {
              System.out.println(num);
              num++;
          }while (num<9);
  
      }
  ```

  #### 数组和数组遍历

```jav
/**
     * 一维数组定义
     */
    @Test
    public void case1(){
        //声明
        int[] arr1;
        //声明+初始化,初始化定义数组长度为3
        int[] arr2=new int[3];
        //为数组赋值
        arr2[0]=1;
        arr2[1]=2;
        arr2[2]=3;
        arr2[3]=4;

        //声明+静态初始化,arr3和arr4是一样的
        int[] arr3=new int[]{1,2,3,4};
        int[] arr4={1,2,3,4};
    }

    /**
     * 一维数组的访问和遍历
     */
    @Test
    public void case2(){
        int[] arr={1,2,3,4};
//        for (int i = 0; i <arr.length ; i++) {
//            System.out.println(arr[i]);
//        }
        //增强for循环
        for (int num:arr) {
            System.out.println(num);
        }
    }
    /**
     * 二维数组的定义、初始化、访问、遍历
     */
    @Test
    public void case3(){
        //声明+初始化，3行2列
        int[][] arr=new int[3][2];
        arr[0][0]=1;
        arr[0][1]=2;
//        arr[0][2]=3;
        arr[1][0]=4;
    }
    @Test
    public void case4(){
        //声明+静态初始化，3*3
        int[][] arr3={{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i <arr3.length ; i++) {
            for (int j = 0; j < arr3[i].length; j++) {
                System.out.println(arr3[i][j]);
            }
        }
    }
```

#### 对象

+ 成员变量：类属性；局部变量

+ 方法参数，有参：

   + 基本数据类型
   + 引用数据类型

  ```jav
  public class demo3 {
      /**
       * 方法参数：
       * 基本数据类型
       *
       * 引用数据类型
       */
      public static void main(String[] args) {
          int i=999;
          demo3 demo3 = new demo3();
          demo3.uodateNum(i);
          //输出999，形参是基本数据类型指向值
          System.out.println(i);
          int[] arr={5,6,7};
          demo3.updateArray(arr);
          for (int i1 = 0; i1 < arr.length; i1++) {
              //输入1，2，3
              System.out.println(arr[i1]);
          }
          UserDemo5 userDemo5 = new UserDemo5();
          userDemo5.name="金莲";
          userDemo5.age=25;
          demo3.updateObject(userDemo5);
          //输出UserDemo5{name='张三', age=20}，形参引用数据类型指向地址
          System.out.println(userDemo5);
  
      }
  
      //cas1、修改基本数据类型
      public void uodateNum(int i){
          i=1024;
      }
      //case2、修改数组
      public void updateArray(int[] arr){
          arr[0]=1;
          arr[1]=2;
          arr[2]=3;
      }
      //case3,修改对象
      public void updateObject(UserDemo5 userDemo5){
          userDemo5.name="张三";
          userDemo5.age=20;
      }
  }
  class UserDemo5{
      String name;
      int age;
  
      @Override
      public String toString() {
          return "UserDemo5{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  ```

