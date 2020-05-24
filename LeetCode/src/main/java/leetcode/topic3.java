package leetcode;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/5 4:23 下午
 */

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class topic3 {
    public static void main(String[] args) {
        //异常测试case:0,负数等
        int a=0;
        System.out.println(isPalindrome(a));

    }

    public static boolean isPalindrome(int x){
        int result=0;
        int num=x;
        if(x>=0){
        while (x!=0){
            int n=x%10;
            result=result*10+n;
            x=x/10;
        }
        if(result==num){
            return true;
        }
        }
        return false;
    }
}
