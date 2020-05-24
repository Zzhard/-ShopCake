package stream;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author zhaoxg
 * @Date 2020/5/24 14:44
 */
public class Demo2 {


    public static void main(String[] args) {
        List<String> list= Lists.newArrayList("ab","xyz","789","asdasdsad");
        List<String> list1 = list.stream()
                .filter(Strings::isNullOrEmpty)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        list1.forEach(str->{
            System.out.println("str = " + str);
        });


    }


}
