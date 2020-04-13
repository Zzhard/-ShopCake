package day02.homewok.Topic4.topic;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/4/13 4:35 下午
 */

/**
 * 多topic4进行重构，支持多种数据类型，并支持自动扩容，用到面向对象的
 */
public class Array {
    private Object[] data;

    private int size;

    private static final int DEFALT_CAPACITY=10;

    public Array() {
        this.data = new Object[DEFALT_CAPACITY];
    }

    public Array(int capacity) {
        this.data = new Object[capacity];
    }
    //----------------数组属性----------
    public int getSize() {
        return this.size;
    }

    public boolean isFull(){
        return this.size==this.data.length;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    //数组增删改查

    public void add(Object element){
        if(isFull()){
            //动态扩容
        }

    }


}
