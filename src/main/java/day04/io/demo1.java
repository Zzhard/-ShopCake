package day04.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @Author zhaoxg
 * @Date 2020/5/11 23:31
 */
public class demo1 {
    public static void main(String[] args) {

    }
    //字节流

    private static void testFileinput() throws Exception {
        File file = new File("");
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes=new  byte[1024];
        while ((bytes=inputStream.read())!=-1){

        }
    }
}
