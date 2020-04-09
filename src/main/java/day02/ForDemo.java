package day02;

import org.testng.annotations.Test;

public class ForDemo {

    /**
     * 循环打印输出1-10
     */

    @Test
    public void case1(){
       for(int i=1;i<=10;i++){
           System.out.println(i);
       }
    }
    /**
     * continue
     * breake 使用
     */

    public void  case2(){
        for (int i = 0; i <10 ; i++) {
            if(i==9){
                System.out.println(i);
                //跳出当前循环，进入下个循环
                continue;
            }
            if (i==9) {
                //跳出循环
                break;
            }
        }
    }
}
