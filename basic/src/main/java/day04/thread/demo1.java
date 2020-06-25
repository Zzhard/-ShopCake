package day04.thread;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/30 12:15 上午
 */
public class demo1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello word");
            }
        });
        thread.start();
    }
}
