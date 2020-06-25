#### 多线程

+ 进程和线程的区别
+ 线程生命周期

+ 创建线程任务的几种方法

  ```java
  public class demo2 {
      public static void main(String[] args) {
          runTask(new ReadFile());
  
      }
  
      public static void runTask(Runnable runnable){
          Thread thread = new Thread(runnable);
          thread.start();
  
      }
  
      static class ReadFile implements Runnable{
          @Override
          public void run() {
              System.out.println("读文件");
          }
      }
      static class ReadMysql implements Runnable{
          @Override
          public void run() {
              System.out.println("读mysql");
          }
      }
      static class ReadHttp implements Runnable{
          @Override
          public void run() {
              System.out.println("读http");
          }
      }
  }
  
  ```

+ 线程安全

  + 出现线程不安全原因(访问内存中同一块数据，修改数据之后刷回缓存，如果没有锁，会导致使用数据出现争抢，出现数据错乱问题)

  + 线程安全

    ```java
    public class demo3 {
        public int data=0;
        Object lock=new Object();
    
        public static void main(String[] args) throws InterruptedException {
            demo3 demo3 = new demo3();
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        demo3.add();
                    }
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        demo3.sub();
                    }
                }
            });
            
            t1.start();
            t2.start();
            //在不加锁的时候将线程添加到主线程，执行结果都是0，这时候是不是就不需要枷锁了呢
            t1.join();
            t2.join();
            System.out.println("demo3.data = " + demo3.data);
        }
        //加锁方式一
        public synchronized void add(){
            
            this.data++;
            //方式二
            //synchronized (this){
            //    this.data++;
            //}
            /**
             * 方式三
             * synchronized (lock){
             *             this.data++;
             *         }
             */
            
        }
        public synchronized void sub(){
            this.data--;
        }
    }
    
    ```

  #### lambda &stream流

  + lambda表达式

    ```java
    import java.util.function.Consumer;
    import java.util.function.Function;
    import java.util.function.Predicate;
    import java.util.function.Supplier;
    
    /**
     *     函数式接口类型：
     *     转换型：Function<T, R>; R apply(T t) 将T转换成R
     *     消费型：Consumer<T>;void accept(T t) 没有返回值
     *     供给型：Supplier<T>,T get()  没有入参，返回R
     *     断言型：Predicate<T>,boolean test(T t);返回boolean类型
     *
     */
    public class Demo4 {
        public static void main(String[] args) {
            //tesFunction();
            //testConsumer();
            //testSupplier();
            testPredicate();
    
        }
    
        private static void testPredicate() {
           /* Predicate<Integer> pre=new Predicate() {
                @Override
                public boolean test(Object o) {
                    return 1 > 2;
                }
            };*/
    
            Predicate<Integer> pre= o -> 1 > 2;
            
            System.out.println(pre.test(1));
    
        }
    
        private static void testSupplier() {
            /*Supplier<String> sup=new Supplier<String>() {
                @Override
                public String get() {
                    return "hello";
                }
            };*/
            Supplier<String> sup= () -> "hello";
            System.out.println(sup.get());
        }
    
        private static void testConsumer() {
            //第一种写法
           /* Consumer<String> consumer=new Consumer<String>() {
                @Override
                public void accept(String s) {
                    System.out.println("s = " + s);
                }
            };*/
    
            Consumer<String> con= s -> System.out.println("s = " + s);
            con.accept("hello world");
        }
    
        private static void tesFunction() {
            //java8之前的写法
            /*Function<String,String> fun1=new Function<String, String>() {
                @Override
                public String apply(String s) {
                    return s.toUpperCase();
                }
            };
            //java8 lambda表达式写法
            Function<String,String> fun2= s -> s.toUpperCase();*/
            //函数引用写法
            Function<String,String> fun3= String::toUpperCase;
            String abc = fun3.apply("abc");
            System.out.println("abc = " + abc);
    
        }
    }
    
    ```

  + lambda主要在stream流中使用

    ```java
    /**
     * lambda的使用
     */
    public class demo5 {
        public static List<String> list= Lists.newArrayList("123","abc","abdasd","789");
    
        public static void main(String[] args) {
            test(list);
        }
        //从集合中筛选出a开头的字符串并打印出来
        private static void test(List<String> lists) {
            lists.stream()
                    .filter(s->s.startsWith("a"))
                    .forEach(s->{
                        System.out.println("s = " + s);
                    });
        }
    }
    ```

  + Stream 流

    + 流化

      + List.stream()
      + 数据量很大的时候使用并行流 list.parallelStream()

    + 流中间操作

      + Filter(),map(),sorted(),skip(),limit(),flatmap(),distinct()

        ```java
        public class Demo1 {
        
            private static List<String> list= Lists.newArrayList("123","abcdf",
                    "axc","aycdz","akcdz12","xsaudau");
            
            public static void main(String[] args) {
                //testFilter();
                //testMap();
                //testSkipAndLimit();
                //testSort();
                ArrayList<String> str1 = Lists.newArrayList("123", "adasd", "knadhh", "cdn");
                ArrayList<String> str2 = Lists.newArrayList("567", "xd", "ckld", "oih");
                ArrayList<String> str3 = Lists.newArrayList("89sad", "kkk", "cnadhh", "cdn");
                ArrayList<String> str4 = Lists.newArrayList("10dad", "adasdasd", "cnadhh", "cdn");
                List<List<String>> strlist=Lists.newArrayList();
                strlist.add(str1);
                strlist.add(str2);
                strlist.add(str3);
                strlist.add(str4);
                testFlastMap(strlist);
            }
            //从List<List<String>> 中筛选出k开头的字符串并转换成大写打印出来
            private static void testFlastMap(List<List<String>> list) {
                list.stream()
                        .flatMap(Collection::stream)
                        .filter(s -> s.startsWith("k"))
                        .map(String::toUpperCase)
                        .forEach(System.out::println);
            }
        
            //sort排序中间操作，取a开头的字符串，并排序
            private static void testSort() {
                list.stream()
                        .filter(s -> s.startsWith("a"))
                        .sorted()
                        .forEach(System.out::println);
            }
        
            //中间操作skip和limit,从第二个开始取，只取3个字符串，并打印输出
            private static void testSkipAndLimit() {
                list.stream()
                        .skip(2)
                        .limit(3)
                        .forEach(System.out::println);
            }
        
            //map()中间操作，映射,使用的是转换型函数；将小写字符串转换成大写
            private static void testMap() {
                list.stream()
                        .filter(s -> s.startsWith("a"))
                        .map(String::toUpperCase)
                        .forEach(System.out::println);
            }
        
            //Filter(),从列表选择长度大于等于5且a开头的字符串
            private static void testFilter() {
                list.stream()
                        //filter过滤
                        .filter(s -> s.length()>=5)
                        .filter(s -> s.startsWith("a"))
                        .forEach(s -> System.out.println("s = " + s));
            }
        }
        ```

    + 结束操作

      + count(),forEach(),findFirst(),findAny()

        ```java
        public class demo3 {
            private static List<String> list= Lists.newArrayList("123","abcdf",
                    "axc","aycdz","akcdz12","xsaudau");
        
            public static void main(String[] args) {
                //testcount();
                testFindfirst();
            }
            //findFirst,findeAny
            private static void testFindfirst() {
                //Optional<String> first = list.stream()
                //        .filter(s -> s.length() >= 5)
                //        .findFirst();
                //System.out.println("first = " + first);
                Optional<String> any = list.stream()
                        .filter(s -> s.length() >= 5)
                        .findAny();
                System.out.println("any = " + any);
            }
        
            //测试结束操作count
            private static void testcount() {
                long count = list.stream()
                        .filter(s -> s.startsWith("a"))
                        .count();
                System.out.println("count = " + count);
            }
        
        }
        ```

        

      + Collection 收集

        + 转成集合 toList,toSet,toMap
        + 分组 groupBy
        + 分区 partitioningBy

        ```java
        /**
         * collection 结束操作
         *  + 转集合(toList ,toMap,toSet)
         *  + 分组：groupBy
         *  + 分区： partitioningBy
         *
         */
        public class demo4 {
            private static List<String> list= Lists.newArrayList("123","","","","abcdf",
                    "axc","aycdz","akcdz12","xsaudau");
        
            public static void main(String[] args) {
                //testTolist();
                //testGroupBy();
                testPatitioningBy();
            }
            //测试分区
            private static void testPatitioningBy() {
                Map<Boolean, List<String>> map = list.stream()
                        .filter(s -> !Strings.isNullOrEmpty(s))
                        .collect(Collectors.partitioningBy(s -> s.length() >= 5));
                map.forEach((k,v)->{
                    if(k){
                        System.out.println("分区长度大于5"+v);
                    }else {
                        System.out.println("分区长度小于5"+v);
                    }
                });
            }
        
            //分组,取出长度大于2的字符串，并按照长度进行分组
            private static void testGroupBy() {
                Map<Integer, List<String>> collect = list.stream()
                        .filter(s -> s.length() >= 2)
                        .collect(Collectors.groupingBy(s -> s.length()));
                //System.out.println(collect.entrySet());
                //for (Map.Entry<Integer, List<String>> entry : collect.entrySet()) {
                //    System.out.println(entry);
                //}
                //遍历map的方法，可以使用forEach
                collect.forEach((k,v)-> System.out.println(k+"="+v));
            }
        
            //取出a开头的字符串，并存到一个集合中
            private static void testTolist() {
                List<String> strings = list.stream()
                        .filter(s -> s.startsWith("a"))
                        .collect(Collectors.toList());
                System.out.println(strings);
            }
        }
        ```

    