package day02.homewok.Topic4.newtopic;

/**
 * @Author zhaoxg
 * @Date 2020/4/14 23:33
 */
public class DynamicArray<E> extends AbstractArray<E> {
    public DynamicArray() {
    }

    public DynamicArray(int capacity) {
        super(capacity);
    }

    //动态数组在添加元素的时候，实现扩容,扩容成原来的2倍
    @Override
    public void handFull() {
        int newCapacity=this.getCapacity()*2;
        if(newCapacity>2086){
            throw new IllegalStateException("超过数组最大容量了，不能再扩容了");
        }
//        E[] newData =(E []) new Object[newCapacity];
//        for (int i = 0; i <this.size ; i++) {
//            newData[i]=this.data[i];
//        }
//        this.data=newData;
        changeData(this.data,newCapacity);
    }

    //在数组删除元素的时候实现缩容
    @Override
    public void handReduce() {
        int newCapacity=this.getCapacity()/2;
//        E[] newData =(E []) new Object[newCapacity];
//        for (int i = 0; i <this.size ; i++) {
//            newData[i]=this.data[i];
//        }
//        this.data=newData;
        changeData(this.data,newCapacity);
    }

    public static<E> void changeData(E[] data,int capacity){
        E[] newData =(E []) new Object[capacity];
        for (int i = 0; i <data.length ; i++) {
            newData[i]=data[i];
        }
        data=newData;
    }
}
