package day04.collection.classcase;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhaoxg
 * @Date 2020/4/22 23:23
 */
/*
case 5:反转Map,实现key->value,value->key
        使用如下键值对，初始化一个HashMap：
        adc - 物理英雄
        apc - 魔法英雄
        t - 坦克
*/

public class case5 {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.put("adc","物理英雄");
        map.put("apc","魔法英雄");
        map.put("t","坦克");
        demo(map);
    }

    private static void demo(Map<String,String> map) {
        Map<String,String> newMap=new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            newMap.put(value,key);
        }
        System.out.println(newMap);

    }
}
