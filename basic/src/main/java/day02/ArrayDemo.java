package day02;

import org.testng.annotations.Test;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/4/9 2:28 下午
 */
public class ArrayDemo {


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
}
