package day02;

import org.testng.annotations.Test;

public class WhileDemo {

    /**
     * while用法
     */
    @Test
    public void case1(){
        int num=0;
        while (num<9){
            num++;
            System.out.println(num);
        }
    }
    /**
     * do while的用法
     */
    @Test
    public void case2(){
        int num=0;
        do {
            System.out.println(num);
            num++;
        }while (num<9);

    }
}
