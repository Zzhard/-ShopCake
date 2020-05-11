package leetcode;

import java.util.HashMap;

/**
 * @Author zhaoxg
 * @Date 2020/5/10 0:05
 *
 * 罗马数字转换成整数
 * I， V， X， L，C，D , M
 */
public class topic7 {
    public static void main(String[] args) {

    }

    public static void test(String str){
        HashMap<Character,Integer> hashMap=new HashMap<>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c1 = chars[i];
            char c2 = chars[i + 1];
            if((c1=='I'||c1=='X'||c1=='C')&&(c2!='C')){

            }
        }


    }
}
