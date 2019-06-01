package com.gavin.thread.lock;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private Lock lock = new ReentrantLock(); // 注意这个地方：lock 被声明为成员变量

    public static void main(String[] args) {
        final TryLock test = new TryLock();

        new Thread("A") {
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();

        new Thread("B") {
            public void run() {
                test.insert(Thread.currentThread());
            };
        }.start();
    }

    public void insert(Thread thread){
        try {
            // 使用 tryLock() 不带参数
            if (lock.tryLock(500,TimeUnit.MILLISECONDS)) {
                try {
                    System.out.println("线程" + thread.getName() + "得到了锁...");
                    for (int i = 0; i < 5; i++) {
                        arrayList.add(i);
                    }
                    //此语句控制锁的耗时
                    Thread.sleep(500);
                } catch (Exception e) {

                } finally {
                    System.out.println("线程" + thread.getName() + "释放了锁...");
                    lock.unlock();
                }
            } else {
                System.out.println("线程" + thread.getName() + "获取锁失败...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
