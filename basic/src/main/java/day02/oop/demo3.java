package day02.oop;



/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/4/9 4:01 下午
 */
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
