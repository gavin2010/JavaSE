package com.gavin.jvm.classloader;

import com.gavin.jvm.bean.A;

import java.util.concurrent.ConcurrentHashMap;

/**
 * classloader的加载顺序
 * @Author zhuxianfeng
 * @Date 2020/6/7 18:15
 * @Dsc
 */
public class ClassLoaderOrder {
    public static void main1(String[] args) throws Exception{
        //装入类,不做内的初始化操作
        ClassLoader classLoader = ClassLoaderOrder.class.getClassLoader();
        Class a = classLoader.loadClass("com.gavin.jvm.bean.A");

        //装入类,并做类的初始化操作
        //Class a = Class.forName("com.gavin.jvm.bean.A");
    }

    public static void main(String[] args) {
       new ClassLoaderOrder();
    }
    {

        ConcurrentHashMap<String,A> parallelLockMap = new ConcurrentHashMap();
        A a1 = new A();
        a1.setStr("A");

        A a2 = new A();
        a2.setStr("B");

        A a3 = parallelLockMap.putIfAbsent("A", a1);
        A a4 = parallelLockMap.putIfAbsent("A", a2);

        Object lock = this;
        if (parallelLockMap != null) {
            Object newLock = new Object();
            if (lock == null) {
                lock = newLock;
            }
        }
    }
}
