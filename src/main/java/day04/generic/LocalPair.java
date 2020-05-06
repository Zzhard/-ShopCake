package day04.generic;

/**
 * @Author zhaoxg
 * @Date 2020/5/6 21:26
 */
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
