package day04.io;

import java.io.*;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/28 9:26 上午
 */
public class demo3 {
    private static String FILEPATH = "/Users/xianggengzhao/Documents/JavaPro/java/ShopCake/basic/src/main/java/day04/io/test.text";

    public static void main(String[] args) {
        //批量修改变量名是 shit + F6
        //testFileWriter(FILEPATH);
        //testBufferWriter(FILEPATH);
        //testFileOutputStream(FILEPATH);
        testOutStream(FILEPATH);
    }

    private static void testOutStream(String path) {
        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(new File(path
        )))) {
            String str="gogoogoo";
            byte[] bytes = str.getBytes();
            outputStream.write(bytes);
            System.out.println("写完了");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testFileOutputStream(String filepath) {
        try (FileOutputStream outputStream = new FileOutputStream(new File(filepath))) {
            String str="helllo";
            byte[] bytes = str.getBytes();
            outputStream.write(bytes,0,str.length());
            System.out.println("写完了");
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testBufferWriter(String filepath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filepath)))) {
            String str="java 世界最好语言";
            writer.write(str);
            System.out.println("写完了");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testFileWriter(String path) {
        try (FileWriter writer = new FileWriter(new File(path))) {
            String str="hello world";
            writer.write(str);
            System.out.println("写文件操作完了");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
