package com.scs.soft.java.basis.practise;

import java.io.*;

/**
 * @author Yujie_Zhao
 * @ClassName BufferedByteFileCopy
 * @Description TODO
 * @Date 2020/1/16  12:18
 * @Version 1.0
 **/
public class BufferedByteFileCopy {
    public static void main(String[] args) {
        File file1 = new File("G:\\randomNumber.txt");
        File file2 = new File("F:\\randomNumber.txt");
        if (!file2.exists()){
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
        byte[] bytes = new byte[1024];
        int len = 0;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);
            try {
                while ((len = fis.read(bytes)) != -1){
                    fos.write(bytes,0,len);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}