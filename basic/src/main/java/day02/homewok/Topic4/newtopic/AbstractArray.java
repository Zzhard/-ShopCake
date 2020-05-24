package day02.homewok.Topic4.newtopic;


/**
 * @Author zhaoxg
 * @Date 2020/4/14 23:05
 */
public abstract class AbstractArray<E> implements Array<E> {
    protected  int size;
    protected static final int DEFAULT_CAPACITY=10;
    protected E[]  data;

    public AbstractArray() {
        this.data=(E[]) new Object[DEFAULT_CAPACITY];
    }

    public AbstractArray(int capacity) {
        this.data=(E[]) new Object[capacity];
    }

    @Override
    public int getCapacity() {
        return this.data.length;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isFull() {
        return this.size==this.data.length;
    }

    @Override
    public boolean isEmpy() {
        return this.size==0;
    }

    @Override
    public void add(E element) {
        if(isFull()){
            //子类中有静态的数组和动态数组，让他们自己去实现抽象类方法
            handFull();
        }
        System.out.println(this.getCapacity());
        this.data[this.size++]=element;

    }
    public abstract void handFull();

    @Override
    public void remove(E element) {
        if(isEmpy()){
            throw new IllegalStateException("数组都空了,删啥");
        }
        if(findIndex(element)!=-1){
            int index = findIndex(element);
            for (int i = index; i <this.size ; i++) {
                this.data[index]=this.data[index+1];
            }
            this.size--;
        }
        if(this.size<this.getCapacity()/2){
            handReduce();
        }

    }
    public abstract void handReduce();

    @Override
    public int findIndex(E element) {
        for (int i = 0; i <this.size ; i++) {
            if(this.data[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

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
