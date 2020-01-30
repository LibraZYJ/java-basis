package com.scs.soft.java.basis.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Yujie_Zhao
 * @ClassName MaxTest
 * @Description 使用反射机调用类的某个方法。
 *              主要用到下面这个方法：public Object invoke(Object obj,Object args)
 *              这个方法对带有指定参数的指定对象调用，由此Method对象表示的底层方法。
 * @Date 2020/1/20  15:56
 * @Version 1.0
 **/
public class MaxTest {
    public static void main(String[] args) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.scs.soft.java.basis.practise.Max");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert clazz != null;

        try {
            //        取得getMax方法
            Method getMaxMethod = clazz.getMethod("getMax",int.class,int.class);
            //        取得print方法
            Method printMethod = clazz.getMethod("print");

            try {
                // 利用反射机制调用以上方法
                // 参数传递：3->a,5->b
                getMaxMethod.invoke(clazz.getDeclaredConstructor().newInstance(),6,5);
                printMethod.invoke(clazz.getDeclaredConstructor().newInstance());

            } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

}
