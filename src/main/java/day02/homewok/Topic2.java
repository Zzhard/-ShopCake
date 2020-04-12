package day02.homewok;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/4/11 8:00 下午
 */

/**
 * 输出1-100以内的质数，
 * 质数：只能被1和本身整除的数
 */
public class Topic2 {
    public static void main(String[] args) {
        boolean flag;
        for (int i = 1; i <=100 ; i++) {
                flag=true;
                for (int j = 2; j <=(int)i/2 ; j++) {
                    if(i<=3){
                        System.out.println(i);
                    }
                    else  if(i%j==0){
                        flag=false;
                        break;
                    }
                }
            if(flag){

                System.out.println(i);
            }
        }
    }
}
