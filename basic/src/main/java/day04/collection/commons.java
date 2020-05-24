package day04.collection;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zhaoxg
 * @Date 2020/5/7 8:04
 */
public class commons {
    public static void main(String[] args) {
        //效果是一样的
        Map<String,String> map = new HashMap<>();
        Map<String, String> map1 = Maps.newHashMap();
    }
}
