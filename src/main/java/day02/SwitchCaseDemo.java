package day02;

import org.testng.annotations.Test;

public class SwitchCaseDemo {
    public static void main(String[] args) {

    }


    /**
     * break关键字，匹配到case时才会跳出switch
     *
     * default关键字作为兜底
     *
     * 可以作为switch表达式数据：byte,short,char,int,枚举，string
     */
    @Test
    public void case1(){
        String str="hello0";
        switch (str){
            case "hello":
                System.out.println("how do you do");
                break;
            case "goodbye":
                System.out.println("goodbye");
            default:
                System.out.println("我不懂你说啥");
        }
    }
    /**
     * 一般业务代码处理，是多个常量进行相同的处理
     */
    @Test
    public void case2(){
        //        int type=1,支付宝，
        //        int type=2,微信，
        //        int type=3,京东，
        //        int type=4,易宝，
        int type=4;
        switch (type){
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("互联网支付");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("非互联网支付");
                break;
            default:
                System.out.println("出错了，不支持支付类型");
        }

    }
}
