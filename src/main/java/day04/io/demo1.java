package day04.io;

import java.io.*;

/**
 * @Author zhaoxg
 * @Date 2020/5/11 23:31
 */
public class demo1 {
    private static String  filepath="D:\\Code\\-ShopCake\\src\\main\\java\\day04\\io\\test.text";
    public static void main(String[] args) throws Exception {
//        testFileInput();
        testBufferInput();

    }

    //字节流读文件
    public static void testFileInput() throws Exception {

        File file = new File("D:\\Code\\-ShopCake\\src\\main\\java\\day04\\io\\test.text");
        FileInputStream inputStream = new FileInputStream(file);
        int len;
        byte[] bytes=new  byte[256];
        StringBuilder builder=new StringBuilder();
        while ((len=inputStream.read(bytes))!=-1){
            String str=new String(bytes,0,len);
            builder.append(str);
        }
        System.out.println(builder.toString());
    }

    //字符流读文件
    public static void testBufferInput(){
        File file = new File(filepath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            StringBuilder sb=new StringBuilder();
            String str;
            while ((str=reader.readLine())!=null){
                sb.append(str).append('\n');
            }
            System.out.println(sb.toString());

        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("文件读取失败");
            throw new RuntimeException(e);
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
