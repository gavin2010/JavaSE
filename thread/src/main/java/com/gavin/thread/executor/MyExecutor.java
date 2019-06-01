package com.gavin.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyExecutor implements Runnable{
    public static void main(String[] args){
        ExecutorService ss = Executors.newFixedThreadPool(1);
        for(int i=0; i<3;i++){
            ss.execute(new MyExecutor(i+""));
        }
    }

    private String name;
    public MyExecutor(String name){
        this.name = name;
    }
    public void run() {
        int n = 0;
        while (n++<5){
            try {
                System.out.println(name);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
