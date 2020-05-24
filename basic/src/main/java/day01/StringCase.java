package day01;

import org.testng.annotations.Test;

public class StringCase {
    /**
     * 1、初始化
     *
     */
    @Test
    public void initStr(){
        String str=null;
        String str1=new String("hello");
        String str2="gogo";
        char[] chars={'a','b','c'};
        String str4=new String(chars);
        System.out.println(str4);
    }
    /**
     * 切片和转换
     */
    @Test
    public void subAndTans(){
        String str="hello world java";
        //从下标为3的字符开始截取
        System.out.println(str.substring(3));
        //从0开始截取到1
        System.out.println(str.substring(0,1));
        //去掉字符串左右空格
        System.out.println(str.trim());
        //其他类型数据转换成string,使用valueOf方法
        int i=5;
        String in=String.valueOf(i);
        System.out.println(in);
    }
    /**
     * 分割和链接
     */
    @Test
    public void sumAndJoin(){
        String str="love,hello,go,sum";
        //split()返回的字符串数组
        String[] split = str.split(",");
        for (String s : split) {
            System.out.println(s);
        }
        //拼接,使用+进行拼接
        String str1="hello";
        String str2="go";
        String str3=str1+str2;
        System.out.println(str3);
        char[] chars={'l','o','v','e'};
        //使用join进行链接
        String s=String.join(";",split);
        System.out.println(s);
    }
    /**
     * 定位、转化、替换
     */

    @Test
    public void moreDetail(){
        //定位,如果存在返回对应字符下标，不存在返回-1
        String str="killer jam";
        System.out.println(str.indexOf("k"));
        //大小写转化,toUpperCase()转化成大写
        System.out.println(str.toUpperCase());
        //替换
        System.out.println(str.replace('j','0'));
    }
    /**
     * String Api
     */

    public void strApi(){
        String str="gogogetgetgo";
        System.out.println(str.startsWith("go"));
        System.out.println(str.endsWith("test"));
        System.out.println(str.contains("123123"));
        //判断字符串是否相同
        System.out.println(str.equals("hahdha"));
        //判断字符串地址是否相等
        System.out.println(str == "hadhhad");
        //不区分大小写，判断是否相等
        System.out.println(str.equalsIgnoreCase("adasd"));
    }

}
