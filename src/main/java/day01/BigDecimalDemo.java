package day01;

import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/1/7 0:50
 */
public class BigDecimalDemo {

    @Test
    public void calBigDecimal(){
        BigDecimal a = new BigDecimal(10);
        BigDecimal b = new BigDecimal(9);
        //add
        System.out.println(a.add(b));
        //subtract
        System.out.println(a.subtract(b));
        //multiply
        System.out.println(a.multiply(b));
        //divide,scale表示精确的小数位，ROUND_HALF_UP表示向“最接近的”数字舍入
        System.out.println(a.divide(b,20,BigDecimal.ROUND_DOWN));
    }
}
