package com.scs.soft.java.basis.ThreadTest;

/**
 * @author Yujie_Zhao
 * @ClassName Ticket
 * @Description 多线程模拟窗口售票程序，注意数据同步
 * @Date 2020/1/30  19:56
 * @Version 1.0
 **/
public class Ticket extends Thread{
    public Ticket(String name) {
        super(name);
    }
    /*票数要使用静态值，才能使多个线程共享*/
    static int tickers=20;
    //指定一个共用对象
    static Object ob;

    //重写run操作，实现卖票
    @Override
    public void run() {
        while(true){
            /*使用线程同步锁synchronized，保证多个线程按次序卖票*/
            synchronized (Ticket.class) {
                if(tickers>0){
                    System.out.println(getName()+":卖出了第"+tickers+"张票");
                    tickers--;
                }else{
                    System.out.println("票卖完了");
                    return;
                }
            }
            try {
                sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        /*实例化线程*/
        Ticket ticket1=new Ticket("窗口一");
        Ticket ticket2=new Ticket("窗口二");
        Ticket ticket3=new Ticket("窗口三");
        ticket1.start();
        ticket2.start();
        ticket3.start();
    }
}
