package day02.homewok.Topic4.newtopic;

/**
 * @Author zhaoxg
 * @Date 2020/4/14 23:01
 */
public interface Array<E> {
    //-----数组的属性-----
    int getCapacity();
    int getSize();
    boolean isFull();
    boolean isEmpy();
    //-----------对数组进行增删改查----

    void add(E element);

    void remove(E element);

    int findIndex(E element);


}
