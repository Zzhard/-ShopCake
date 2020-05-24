package day01;

import org.testng.annotations.Test;

public class Operate {

    enum size{
        samll,middle,large
    };

    /**
     * 加、减、乘、除、取模
     */

    /**
     * 自增和自减
     */
    @Test
    public void add(){
        int i=1;
        //i=1;j=i=1,i=i+1=2
        int j=i++;
        //i=2;k=i+1=3;i=i+1=3
        int k=++i;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }
    /**
     *逻辑运算符和短路
     */
    @Test
    public void logiCal(){
        boolean b1=true;
        boolean b2=false;
        if(b2&&b1){
            System.out.println("逻辑&&必须条件都是true，前面是false时就不会判断后面条件");
        }
        if(b1||b2){
            System.out.println("逻辑||前面的条件是true就不会判断后面的条件");
        }
    }

    @Test
    public void sanMu(){
        System.out.println(1>2 ? "false":"true");
    }

    @Test
    public void enui(){

    }

}
