package day04.collection.classcase.case6;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @Author zhaoxg
 * @Date 2020/4/22 23:30
 */
/*case 6: 定义一个类,实现一个key对应一个列表.数据类型是泛型
        具备最基本的数据添加,遍历等基本常用方法
        作业: 实现自Map接口
        */
public class case6<K,V> implements Map {
    private K k;
    private V v;
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
