package com.scs.soft.java.basis.ThreadTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * @author Yujie_Zhao
 * @ClassName Pool
 * @Description TODO
 * @Date 2020/1/30  20:13
 * @Version 1.0
 **/
public class Pool implements Runnable {
    private int taskNum;

    public Pool(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在下载图片");
        try {
            File file = new File("D:\\" + this.taskNum + ".jpg");
            downloadPicture(file);
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "下载图片完成");
    }

    public static void downloadPicture(File file) throws IOException {
        BufferedImage image = null;
        try {
            URL url = new URL("https://niit-zyj.oss-cn-beijing.aliyuncs.com/img/3001df0d-9b2e-478b-81ec-7ebdeb38adce.png");
            image = ImageIO.read(url);
            ImageIO.write(image, "jpg", file);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

    }
}
