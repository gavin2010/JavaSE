package com.gavin.thread.lock;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class LockDemo1 {
    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
    Lock lock = new ReentrantLock(); //不能申明为局部变量

    public static void main(String[] args) throws Exception {
        final LockDemo1 test = new LockDemo1();
        Thread t1 =new Thread("A") {
            public void run() {
                Thread.yield();
                test.insert(Thread.currentThread());
            };
        };
        Thread t2 =new Thread("B") {
            public void run() {
                //Thread.yield();
                test.insert(Thread.currentThread());
            };
        };

        t1.start();
        t2.start();
    }

    public void insert(Thread thread) {
      //  Lock lock = new ReentrantLock();  // 注意这个地方:lock被声明为局部变量
        lock.lock();
        try {
            System.out.println("线程" + thread.getName() + "得到了锁...");
            for (int i = 0; i < 10; i++) {
                arrayList.add(i);
            }
        } catch (Exception e) {

        } finally {
            System.out.println("线程" + thread.getName() + "释放了锁...");
            lock.unlock();
        }
    }
}
