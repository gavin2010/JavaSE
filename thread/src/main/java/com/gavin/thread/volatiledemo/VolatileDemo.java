package com.gavin.thread.volatiledemo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileDemo {

   // public volatile int inc = 0;

    //方式一 导致最终结果不正确，没有保证原子性，可见性、和顺序性
   /* public int inc = 0;
     public void increase(){
        inc++;
    }*/

   //方式二 导致最终结果不正确，虽然保证了可见性，和顺序性，但是没有保证原子性
    /*public volatile int inc = 0;
    public void increase(){
        inc++;
    }*/


    //方式三 最终结果正确，保证了原子性, 也就间接地保证了可见性，和顺序性
  /*  public int inc = 0;
    public synchronized void increase(){
        inc++;
    }*/

    //方式四 最终结果正确，保证了原子性, 也就间接地保证了可见性，和顺序性
   /* Lock lock = new ReentrantLock();
    public int inc = 0;
    public void increase(){
        lock.lock();
        try {
            inc++;
        } finally {
            lock.unlock();
        }
    }*/

    //方式五 最终结果正确，保证了原子性, 也就间接地保证了可见性，和顺序性
    public AtomicInteger inc = new AtomicInteger();
    public void increase(){
        inc.getAndIncrement();
    }

    public static void main(String[] args){

        final VolatileDemo test = new VolatileDemo();
        List<Thread> list = new ArrayList<Thread>();

        for (int i=0;i<10;i++){
            Thread thread = new Thread(){
                public void run(){
                    for (int j=0;j<1000;j++){
                        test.increase();
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            thread.start();
            list.add(thread);
        }

        for (Thread thread : list){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(test.inc);
    }
}
