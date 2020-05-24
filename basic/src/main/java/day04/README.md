#### 集合

##### 1、List、set、map

+ List 接口是有序的、可重复的，重要的子类ArrayList和LinkList
+ Set 接口是无序，不可重复的
+ Map
+ 具体去看源码

##### 2、集合体系

```markdown
* interface Iterable<T>
    - interface Collection<E> extends Iterable<E>
        + interface Set<E> extends Collection<E>
            * class **HashSet**<E> extends AbstractSet<E> implements Set<E>
            * class **LinkedHashSet**<E> extends HashSet<E> implements Set<E>
        + interface List<E> extends Collection<E>
            * class **ArrayList**<E> extends AbstractList<E> implements List<E>
            *  class **LinkedList**<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>
            *  class CopyOnWriteArrayList<E> implements List<E>
        + interface Queue<E> extends Collection<E>
            * interface BlockingQueue<E> extends Queue<E>
            * interface Deque<E> extends Queue<E>
            * class ConcurrentLinkedQueue<E> extends AbstractQueue<E> implements Queue<E>
* interface Map<K,V>
    - abstract class AbstractMap<K,V> implements Map<K,V>
        + class **HashMap**<K,V> extends AbstractMap<K,V> implements Map<K,V>
            * class **LinkedHashMap**<K,V> extends HashMap<K,V> implements Map<K,V>
        + class **TreeMap**<K,V> extends AbstractMap<K,V> implements NavigableMap<K,V>,
    - class Hashtable<K,V> extends Dictionary<K,V> implements Map<K,V>
```



##### 3、练习题

```html
 <h4 id="collection-test">练习</h4>
    + case 1: 定义一个Map, key是userId, value是User. 
        * 要求遍历整个Map的数据
        * User{userId,name,age,Map<String,List<String>> hobby}
        * 如: u001,大叔,hobby(文学=[金瓶梅,春闺秘史,如何重整男人雄风], 电影=[岛国动作模仿秀,慈禧的后宫秘史])
    + case 2: 基于case1的定义,对年纪进行分组
        * 20以下是青年,20到30是中年,30以上是老年
        * 要求,遍历出每个组内的所有人
    + case 3:基于case1的定义,要求对爱好分组,喜欢文学的一组人, 喜欢电影的一组人
    + case 4:生成50个0-9999之间的随机数,要求不能有重复的
    + case 5:反转Map,实现key->value,value->key
        * 使用如下键值对，初始化一个HashMap：
        * adc - 物理英雄
        * apc - 魔法英雄ss
        * t - 坦克
    + case 6: 定义一个类,实现一个key对应一个列表.数据类型是泛型
        * 具备最基本的数据添加,遍历等基本常用方法
        * 作业: 实现自Map接口
```



#### 泛型

##### 出现的意义

+ 将运行时的遇到的问题转移到了编译期

+ 为编码时期不确定性做了设计

  ```java
  public static void main(String[] args) {
          //编译的时候代码并没有报错，但是运行时会报错，因为foo2返回的两个值中有一个时Integer
          LocalPair pair = foo2();
          String val1 =(String) pair.getVal1();
          String val2 =(String) pair.getVal2();
          String[] strings = val1.split(",");
          for (int i = 0; i < strings.length; i++) {
              System.out.println(strings);
          }
  
  
      }
      //LocalPair类的两个属性时object类型
      private static LocalPair foo1() {
          LocalPair pair = new LocalPair("abc,bcd","efg,hij");
          return pair;
      }
      private static LocalPair foo2(){
          LocalPair pair = new LocalPair(123, "abc,dj");
          return pair;
      }
  LocalPair类
      public class LocalPair {
  
      private Object val1;
      private Object val2;
  
      public LocalPair(Object val1, Object val2) {
          this.val1 = val1;
          this.val2 = val2;
      }
  
      public Object getVal1() {
          return val1;
      }
  
      public void setVal1(Object val1) {
          this.val1 = val1;
      }
  
      public Object getVal2() {
          return val2;
      }
  
      public void setVal2(Object val2) {
          this.val2 = val2;
      }
  }
  泛型解决的问题 LocalPair2类，再编译时就会报错了，不需要等到运行再报错
      public class LocalPair2<K,V> {
      private K k;
      private V v;
  
      public LocalPair2(K k, V v) {
          this.k = k;
          this.v = v;
      }
  
      public K getK() {
          return k;
      }
  
      public void setK(K k) {
          this.k = k;
      }
  
      public V getV() {
          return v;
      }
  
      public void setV(V v) {
          this.v = v;
      }
  }
  
  ```

##### 定义

+ 静态
+ 非静态

##### 使用示例

+ 静态工厂方法

+ Pair

+ 通用数据包装

  ```java
  public class RetMsg<T> {
      
      private int errorCode;
      private String errorMsg;
      private T data;
      private static final int SUCCESS_CODE=2000;
      private static final String SUCCESS_MSG="success";
  
      public RetMsg(int errorCode, String errorMsg, T data) {
          this.errorCode = errorCode;
          this.errorMsg = errorMsg;
          this.data = data;
      }
  
      public int getErrorCode() {
          return errorCode;
      }
  
      public void setErrorCode(int errorCode) {
          this.errorCode = errorCode;
      }
  
      public String getErrorMsg() {
          return errorMsg;
      }
  
      public void setErrorMsg(String errorMsg) {
          this.errorMsg = errorMsg;
      }
  
      public T getData() {
          return data;
      }
  
      public void setData(T data) {
          this.data = data;
      }
      
      //静态定义，工厂方法，包装数据类
      public static<R> RetMsg<R> builSuccessMsg(R data){
          return new RetMsg<>(SUCCESS_CODE,SUCCESS_MSG,data);
      }
  }
  
  调用RetMsg,不需要再使用new 构造对象
   RetMsg.builSuccessMsg("success data")
  ```

##### commons lang3 Pair类使用

```java
需要导入 import org.apache.commons.lang3.tuple.Pair;
 //方法需要返回两个值，可以直接用Pair
Pair<String, String> pair = Pair.of("abc", "bcd");
//getKey()和getLeft()一样
pair.getKey();
System.out.println("pair.getLeft() = " + pair.getLeft());

pair.getValue();
System.out.println("pair.getRight() = " + pair.getRight());

```









