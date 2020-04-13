package day02.homewok.Topic4;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/4/12 10:39 下午
 */

import java.util.Arrays;

/**
 * 作业4: 封装一个数组对象(暂时用int型即可)
 *
 * 可先定义个数组看下,比如int[],有哪些方法提供,太少了
 *
 * 要求实现: 数组类
 *
 * - new 时传入指定大小
 *
 * - 可以添加元素
 *
 * - 可以删除元素
 *
 * - 可以根据给定元素,找到索引位置
 *
 * - 并支持跨度寻找,如find(1234,5),即夸过5个索引之后寻找
 *
 * - 实现对数组的遍历功能
 *
 * - 实现判断数组是否为空
 *
 * - 不理解,看下Topic6,栈的设计
 */
public class Arraylist {
    private int[] arr;

    private int size;

    private static final int DEFALT_CAPACITY=10;

    //1、初始化,默认数组的长度是10
    public Arraylist() {
        this.arr=new int[DEFALT_CAPACITY];
    }
    public Arraylist(int capacity) {
        this.arr=new int[capacity];
    }
    //-----------------2、获取数组的长度、判断数组是否为空，判断数组是否以满
    public int getSize(){
//        this.size=this.arr.length;
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public boolean isFull(){
        return this.size==this.arr.length;
    }
    //3、增加元素,把元素加到数组最后一个,这个应该支持数组的扩容
    public void add(int element){
       if(isFull()){
           System.out.println("数组已满，无法添加");
       }
       this.arr[this.size++]=element;

    }
    //4、根据指定元素进行删除
    public void del(int element){
        int index = getIndex(element);
        if(index!=-1){
            for (int i = index; i <this.size; i++) {
                this.arr[i]=this.arr[i+1];
            }
            this.size--;
        }else {
            System.out.println(String.format("%s在数组中不存在",element));
        }

    }
    //5、给定元素找到索引
    public int getIndex(int element){
        for (int i = 0; i <this.size ; i++) {
           if(this.arr[i]==element){
               return i;
           }
        }
        return -1;
    }
    //打印数组
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i <this.size; i++) {
            if(i==this.size-1){
                builder.append(this.arr[i]+"]");
                continue;
            }
            builder.append(this.arr[i]+",");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Arraylist arraylist = new Arraylist();
        arraylist.add(5);
        arraylist.add(6);
        arraylist.add(7);
        arraylist.add(8);
        arraylist.add(9);
        arraylist.add(10);
        arraylist.add(11);
        arraylist.add(12);
        System.out.println(arraylist.getSize());
        System.out.println(arraylist.toString());
//        System.out.println(arraylist.getIndex(0));
        arraylist.del(0);
        System.out.println(arraylist.toString());
    }

}
