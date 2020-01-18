package com.scs.soft.java.basis.practise;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Yujie_Zhao
 * @ClassName ReadImgToFile
 * @Description 指定一个本地路径，从该路径的所有子路径获取所有图片类型的文件，
 *              得到一个File数组，将其按照文件大小排序输出
 * @Date 2020/1/17  23:14
 * @Version 1.0
 **/
public class ReadImgToFile {

    public static void main(String[] args) {
        File file = new File("D:/test");
        ArrayList<String> files = new ReadImgToFile().getFiles(file);
        System.out.println(files);

    }


    public ArrayList<String> getFiles(File path) {
        ArrayList<String> files = new ArrayList<String>();
        //        存放我需要的文件
        ArrayList<String> fileList  = new ArrayList<>();


        File file = new File(String.valueOf(path));
        File[] tempList = file.listFiles();

        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].isFile()) {
              System.out.println("文     件：" + tempList[i]);
                files.add(tempList[i].toString());
            }
            if (tempList[i].isDirectory()) {
             System.out.println("文件夹：" + tempList[i]);
            }
        }
//        自动排降序
        Collections.reverse(files);
        System.out.println(files);

        int length = files.size();
//        list转数组
        File[] tempList2 = new File[length];
        for(int i = 0; i < length;i++){
            tempList2[i] = new File(files.get(i));
        }
        for (int i = 0; i < length; i++) {
            if (!tempList2[i].isFile()) {
                continue;
            }
            String icon=tempList2[i].getAbsolutePath();
            if (icon.endsWith(".png") || icon.endsWith(".PNG") ||
                    icon.endsWith(".jpg") || icon.endsWith(".jpg")){
                fileList.add(icon);
            }
        }
        return fileList;
    }


}
