package com.scs.soft.java.basis.practise;

/**
 * @author Yujie_Zhao
 * @ClassName Max
 * @Description TODO
 * @Date 2020/1/20  15:58
 * @Version 1.0
 **/
public class Max {
    private  int max;
    public int getMax(int a, int b){
        this.max = Math.max(a,b);
        return max;
    }
    public void print(){
        System.out.println("最大值="+ this.max);
    }
}
