package day04.io;

import java.io.*;

/**
 * @author zhaoxg
 * @version 1.0
 * @date 2020/5/27 11:09 下午
 */
public class demo2 {
    private static String FILEPATH = "/Users/xianggengzhao/Documents/JavaPro/java/ShopCake/basic/src/main/java/day04/io/test.text";

    public static void main(String[] args) {
        //1、字节流
        //testFileInputStream(FILEPATH);
        testBufferInputStream(FILEPATH);
        //testFileReader(FILEPATH);

    }

    private static void testBufferInputStream(String filepath) {
        File file = new File(filepath);
        //FileInputStream继承InputStream，InputStream则实现Closeable，所以可以自动关流
        try (BufferedInputStream inputStream= new BufferedInputStream(new FileInputStream(file))) {
            int len;
            byte[] bytes = new byte[256];
            StringBuilder builder = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                builder.append(s);
            }
            System.out.println(builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void testFileReader(String path) {
        try (FileReader reader = new FileReader(new File(path))) {
            int len;
            char[] chars=new char[256];
            StringBuilder builder=new StringBuilder();
            while ((len=reader.read(chars))!=-1){
                String s=new String(chars,0,len);
                builder.append(s);
            }
            System.out.println(builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testBufferReader(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String s = null;
            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void testFileInputStream(String path) {
        File file = new File(path);
        //FileInputStream继承InputStream，InputStream则实现Closeable，所以可以自动关流
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            int len;
            byte[] bytes = new byte[256];
            StringBuilder builder = new StringBuilder();
            while ((len = fileInputStream.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                builder.append(s);
            }
            System.out.println(builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
