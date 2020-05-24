package day02;

import org.testng.annotations.Test;

import java.util.Scanner;

public class IfelseDemo {


    /**
     * case1只有一条分支
     */
    @Test
    public void case1(){
        int num=10;
        if(num<20){
            System.out.println("输出结果正确");
        }
    }

    /**
     * 多条分支
     */

    @Test
    public void  case2(){
        int num=10;
        if(num<9){
            System.out.println("小于");
        }else if(num>9){
            System.out.println("大于");
        }else if(num==10) {
            System.out.println("等于");
        }else {
            System.out.println("error");
        }
    }

    /**
     * 猜数字
     * @param args
     */
    public static void main(String[] args) {
        int num=(int)(Math.random()*100);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int i = scanner.nextInt();
            if(i==num){
                System.out.println("哈哈，恭喜你猜对了");
                break;
            }else if(i<num){
                System.out.println("小了，继续猜");
            }else if(i>num){
                System.out.println("大了");
            }else {
                System.out.println(String.format("%s输入的数据有问题", num));
            }
        }
    }
}
