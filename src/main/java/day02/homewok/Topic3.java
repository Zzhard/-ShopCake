package day02.homewok;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/4/12 2:50 下午
 */

import javafx.util.Pair;
import org.testng.util.Strings;

import java.util.Scanner;

import static java.lang.Integer.valueOf;

/**
 * 实现一个计算器
 * -1、接收客户端的输入三个数据，格式：数据1 操作符 数据2，如1 + 2
 * -2、如果数据1和2是数值型，则进行相应的运算操作
 * -3、如果数据1和2不是数值型，则数据1和数据2按字符串处理，与运算符一起拼接后输出，如 abc - bcd 输出"abc - bcd "
 * 备注：
 * -1.计算器运算符只支持+,-,*,/,%
 * -2.数据和运算符直接使用空格隔开
 */
public class Topic3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输出两个数据和操作符，例如：1 + 2");
        String s = scanner.nextLine();
        //要对输入数据格式进行判断，首先要包含5个字符并且包含空格，其实使用正则来匹配更好
        if(s.contains(" ")&&s.length()==5){

            String[] s1 = s.split(" ");
            String num1=s1[0];
            String num2=s1[2];
            switch (s1[1]){
                case "+":
                    if(isNum(num1)&&isNum(num2)){
                        //判断num1是float还是int
                        if(num1.contains(".")&&num2.contains(".")){
                            Pair<Integer, Float> num = getNum(num1);
                            Pair<Integer, Float> num3 = getNum(num2);
                            float num4=num.getValue()+num3.getValue();
                            System.out.println(num1+" "+"+"+num2+" ="+num4);

                        }
                        if(num1.contains(".")&&!num2.contains(".")){
                            Pair<Integer, Float> num = getNum(num1);
                            Pair<Integer, Float> num3 = getNum(num2);
                            float num4=num.getValue()+num3.getKey();
                            System.out.println(num1+" "+"+"+num2+" ="+num4);

                        }if(!num1.contains(".")&&num2.contains(".")){
                            Pair<Integer, Float> num = getNum(num1);
                            Pair<Integer, Float> num3 = getNum(num2);
                            float num4=num.getKey()+num3.getValue();
                            System.out.println(num1+" "+"+"+num2+" ="+num4);

                        }if (!num1.contains(".")&&!num2.contains(".")){
                            Pair<Integer, Float> num = getNum(num1);
                            Pair<Integer, Float> num3 = getNum(num2);
                            int num4=num.getKey()+num3.getKey();
                            System.out.println(num1+" "+"+"+num2+" ="+num4);
                        }
                    }
                    else {
                        System.out.println(num1+" "+"+"+num2);
                    }
                    break;
                default:
                    System.out.println(String.format("%s输入操作符不对", s1[1]));
                    throw new IllegalStateException("Unexpected value: " + s1[1]);
            }
        }else {
            System.out.println("输入的数据和操作符格式错误");
        }



    }
    //判断输入的是否是数值型
    public static boolean isNum(String str){
        //1、判断不是为空
//        str=str.trim();
        if(Strings.isNullOrEmpty(str)){
            System.out.println("输入的数据不能为空");
        }
        //2、这种方法只能判断是否是整数，不是判断str是否是浮点型数据

//        for (int i = 0; i <str.length() ; i++) {
//            if(!(Character.isDigit(str.charAt(i))&&Character.)){
//                return false;
//            }
//        }
        //3、使用正则，判断str是否是数值型
        String reg = "^[0-9]+(.[0-9]+)?$";
        return str.matches(reg);
    }
    //改方法用于string 转换成int 或者float，如果是int，则返回int ,如果是float返回float

    public static Pair<Integer,Float> getNum(String str){
        Float num1=null;
        Integer num2=null;
        if(str.contains(".")){
            num1=Float.parseFloat(str);
        }else {

            num2= valueOf(str);
        }
        return new Pair<Integer, Float>(num2,num1);


    }



}
