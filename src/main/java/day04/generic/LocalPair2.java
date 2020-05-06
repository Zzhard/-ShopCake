package day04.generic;

/**
 * @Author zhaoxg
 * @Date 2020/5/6 22:02
 */
public class LocalPair2<K,V> {
    private K k;
    private V v;

    public LocalPair2(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }
}
