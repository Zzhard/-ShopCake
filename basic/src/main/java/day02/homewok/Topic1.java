package day02.homewok;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/4/11 7:56 下午
 */

/**
 * 实现99乘法表
 */
public class Topic1 {
    public static void main(String[] args) {
        for (int i = 1; i <=9; i++) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(i+"*"+j+"="+i*j+" ");
            }
            System.out.println();
        }
    }
}
