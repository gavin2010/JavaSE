package com.gavin.thread.volatiledemo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VolatileDemo2 implements Runnable{
    ThreadFlag threadFlag = null;

    public VolatileDemo2(ThreadFlag threadFlag){
        this.threadFlag = threadFlag;
    }

    public void run() {
        while(!threadFlag.isFlag());
    }

    public static void main(String[] args) throws Exception{
        ThreadFlag threadFlag = new ThreadFlag();
        Thread t1 = new Thread(new VolatileDemo2(threadFlag));
        Thread t2 =  new Thread(threadFlag);
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        t1.join();
        t2.join();
        System.out.println("test end");
    }

}

class ThreadFlag implements Runnable{
    //不加上volatile 有可能刷新不了导致继续循环
     boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public void run() {
        setFlag(true);
    }
}
