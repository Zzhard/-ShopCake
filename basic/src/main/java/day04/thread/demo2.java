package day04.thread;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/30 12:16 下午
 */
public class demo2 {
    public static void main(String[] args) throws InterruptedException {
        runTask(new ReadFile());

    }

    public static void runTask(Runnable runnable) throws InterruptedException {
        Thread thread = new Thread(runnable);
        Thread.sleep(1000*30);
        thread.start();

    }

    static class ReadFile implements Runnable{
        @Override
        public void run() {
            System.out.println("读文件");
        }
    }
    static class ReadMysql implements Runnable{
        @Override
        public void run() {
            System.out.println("读mysql");
        }
    }
    static class ReadHttp implements Runnable{
        @Override
        public void run() {
            System.out.println("读http");
        }
    }
}
