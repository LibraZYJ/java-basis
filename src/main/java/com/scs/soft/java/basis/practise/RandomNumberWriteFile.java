package com.scs.soft.java.basis.practise;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * @author zyj
 *
 */
public class RandomNumberWriteFile {
    public static void main(String[] args) throws IOException{
        int[] rand = new int[100];
        /*定义随机数*/
        Random random = new Random();
        File file = new File("D:\\random.txt");
        Writer writer = new FileWriter(file);;
        PrintWriter out = new PrintWriter(writer);
        int len = rand.length;
        for(int i = 0; i < len; i++){
            rand[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(rand));
        out.print(Arrays.toString(rand));
        out.flush();
        out.close();
        writer.close();
    }
}
