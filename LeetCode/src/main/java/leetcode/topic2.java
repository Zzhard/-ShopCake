package leetcode;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/5 4:06 下午
 */

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意：数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0
 *
 * 思路：123
 * 1、获取每个位置上的数,先获取3,再获取2，再获取1
 * 2、获取3之后，3变为个位数，2为十位，即3*10+2，依次类推
 * 3、考虑反转后溢出的情况,-2的31次方 和 2的31次方值范围是：-2147483648~2147483647
 */
public class topic2 {
    public static void main(String[] args) {
        System.out.println(reverse(120));
        int a=1534236469;
        System.out.println(reverse(a));

    }

    public static int reverse(int x){

        double max = Math.pow(2, 31)-1;
        double min = Math.pow(-2, 31);
        int result=0;
            while (x!=0){
                int n=x%10;
                if(result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&n>7)){
                    return 0;
                }
                if(result<Integer.MIN_VALUE/10||(result==Integer.MIN_VALUE/10&&n<-8)){
                    return 0;
                }
                result=result*10+n;
                x=x/10;
            }
            return result;
    }


}
