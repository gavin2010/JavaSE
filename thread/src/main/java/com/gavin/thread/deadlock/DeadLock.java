package com.gavin.thread.deadlock;

public class DeadLock{
  public static void main(String[] args){
        Object objA = new Object();
        Object objB = new Object();
        Thread t1 = new Thread(new PersonA("A",objA,objB));
        Thread t2 = new Thread(new PersonB("B",objA,objB));
        t1.start();
        t2.start();

  }
}

class PersonA implements Runnable{
    Object objA;
    Object objB;
    private String name;
    public PersonA(String name,Object objA,Object objB){
        this.objA = objA;
        this.objB = objB;
        this.name = name;
    }

    public void run() {
        synchronized (objA){
            System.out.println(name+"已经获得A锁……");
            //Thread.yield();
            synchronized (objB){
                System.out.println(name+"已经获得B锁……");

            }
        }
    }
}

class PersonB implements Runnable{
    Object objA;
    Object objB;
    private String name;
    public PersonB(String name,Object objA,Object objB){
        this.objA = objA;
        this.objB = objB;
        this.name = name;
    }

    public void run() {
        synchronized (objB){
            System.out.println(name+"已经获得B锁……");
           // Thread.yield();
            synchronized (objA){
                System.out.println(name+"已经获得A锁……");
            }
        }
    }
}
