package com.gavin.thread.volatiledemo;

public class Volatile {
   // volatile boolean ready=true;  //volatile 状态标志变量
    boolean ready=true;
    private final static int SIZE = 10; //创建10个对象，可改变

    public static void main(String[] args) throws InterruptedException{

        Volatile vs[]=new Volatile[SIZE];

        for(int n=0;n<SIZE;n++)
            (vs[n]=new Volatile()).test();

        System.out.println("mainThread end");//调用结束打印，死循环时不打印
    }

    public void test() throws InterruptedException{
        Thread t2=new Thread(){
            public void run(){
                while(ready);//变量为true时，让其死循环
            }
        };
        Thread t1=new Thread(){
            public void run(){
                ready=false;
            }
        };
        t2.start();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
        t1.join();//保证一次只运行一个测试，以此减少其它线程的调度对 t2对boolValue的响应时间 的影响
        t2.join();
    }
}
