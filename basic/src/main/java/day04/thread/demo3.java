package day04.thread;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/30 3:00 下午
 */
public class demo3 {
    public int data=0;
    Object lock=new Object();

    public static void main(String[] args) throws InterruptedException {
        demo3 demo3 = new demo3();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    demo3.add();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    demo3.sub();
                }
            }
        });

        t1.start();
        t2.start();
        //在不加锁的时候将线程添加到主线程，执行结果都是0，这时候是不是就不需要枷锁了呢
        t1.join();
        t2.join();
        System.out.println("demo3.data = " + demo3.data);
    }
    //加锁方式一
    public synchronized void add(){

        this.data++;
        //方式二
        //synchronized (this){
        //    this.data++;
        //}
        /**
         * 方式三
         * synchronized (lock){
         *             this.data++;
         *         }
         */

    }
    public synchronized void sub(){
        this.data--;
    }
}
