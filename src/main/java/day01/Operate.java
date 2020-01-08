package day01;

import org.testng.annotations.Test;

public class Operate {

    /**
     * 加、减、乘、除、取模
     */

    /**
     * 自增和自减
     */
    @Test
    public void add(){
        int i=1;
        int j=i++;
        System.out.println(i);
        System.out.println(j);
    }

}
