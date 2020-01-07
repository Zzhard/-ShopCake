package day01;



import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * 基本数据类型测试
 */

public class DataType {
    /**
     * 1、金融业务为避免浮点计算，一般使用单位为分的long表示
     */
    @Test
    public void aboutMoney(){
        //表示12元4角8分
        long a=1248;
        System.out.printf("金额"+ a);
    }
    /**
     * 2、浮点型计算丢失精度案例
     */
    @Test
    public void calcFloat(){
        //案例1
        double a=1;
        double b=0.99;
        //结果是0.010000000000000009
        System.out.println(a-b);
        //案例2
        float c=1;
        float d=0.99f;
        //0.00999999
        System.out.println(c-d);
        /**
         * 造成精度丢失的原因是：浮点数值采用二进制系统表示， 而在二进制系统中无法精确地表示分数 1/10
         */
    }
    /**
     * 解决浮点计算丢失精度的办法BigDecimal
     */
    @Test
    public void calcBigDecimal(){
        //case1 直接使用BigDecimal计算
        BigDecimal a=new BigDecimal(1);
        BigDecimal b=new BigDecimal(0.99);
        System.out.println(a.subtract(b));
        //case2 使用BigDecimal+Sring 来计算更精确
        BigDecimal c = new BigDecimal("1");
        BigDecimal d = new BigDecimal("0.99");
        System.out.println(c.subtract(d));
    }
}
