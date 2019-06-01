package com.gavin.thread.notify;

public class WaitDemo implements Runnable{
    private String name;
    public  WaitDemo(String name,Object obj) {
        this.obj = obj;
        this.name = name;
    }

    private Object obj;

    public void run() {
        synchronized (obj){
            int n = 10;
            while( n-- > 0){
                System.out.println(name);
                obj.notify();
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name+"线程执行完毕！");

        }
    }


    public static void main(String[] args) throws Exception{
        Object obj = new Object();
        Thread t1 = new Thread(new WaitDemo("A",obj));
        Thread t2 = new Thread(new WaitDemo("B",obj));
        t1.start();
        Thread.sleep(5);
        t2.start();
        t1.join();

        Thread.sleep(1);
        synchronized (obj){
            System.out.println("main解锁wait");
            obj.notify();
           /* System.out.println("是否中断："+t2.isInterrupted());
            t2.interrupt();
            System.out.println("是否中断："+t2.isInterrupted());*/
        }
        Thread.yield();
        System.out.println("end");

    }
}
