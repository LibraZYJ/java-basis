package com.scs.soft.java.basis.ThreadTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * @author Yujie_Zhao
 * @ClassName ThreadPool
 * @Description TODO
 * @Date 2020/1/30  20:10
 * @Version 1.0
 **/
public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 2; i++) {
            Pool pool = new Pool(i);
            executor.execute(pool);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + "，队列中等待执行的任务数目：");
        }
        executor.shutdown();
    }
}
