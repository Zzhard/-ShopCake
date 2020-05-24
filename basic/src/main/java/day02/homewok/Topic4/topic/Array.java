package day02.homewok.Topic4.topic;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/4/13 4:35 下午
 */


/**
 * 多topic4进行重构，支持多种数据类型，并支持自动扩容，用到面向对象的
 */
public class Array<E> {
    private E[] data;

    private int size;

    private static final int DEFALT_CAPACITY=10;

    public Array() {
        this.data =(E[])new Object[DEFALT_CAPACITY];
    }

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
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

    //----------增删查

    public   void add(E element){
        if(isFull()){
            //动态扩容
            throw new IllegalStateException("\"数组已满，无法添加\"");
        }
        this.data[this.size++]=element;

    }
    public void delete(E element){
        if(isEmpty()){
            throw  new IllegalStateException("数组已空,无法进行删除");
        }
        int index = getIndex(element);
        if(index!=-1){


        }

    }

    public int getIndex(E element){
        for (int i = 0; i <this.size ; i++) {
            if(this.data[i]==element){
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
                builder.append(this.data[i]+"]");
                continue;
            }
            builder.append(this.data[i]+",");
        }
        return builder.toString();
    }



}
