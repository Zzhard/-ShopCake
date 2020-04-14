package day02.homewok.Topic4.newtopic;

/**
 * @Author zhaoxg
 * @Date 2020/4/14 23:36
 */
public class StaticArray<E> extends AbstractArray<E> {
    public StaticArray() {
    }

    public StaticArray(int capacity) {
        super(capacity);
    }

    @Override
    public void handFull() {
        throw new IllegalStateException("数组已满不能再添加");
    }

    @Override
    public void handReduce() {
        return;
    }
}
