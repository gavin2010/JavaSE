package com.gavin.jvm.initorder;

public class InitOrder {
    public static void main(String[] args) throws Exception{
       B ab = new B();
       A  abC = new A();

    }
}

class A{

    static{
        System.out.print("1");
    }

    public A(){
        System.out.print("2");
    }
}

class B extends A{
    static{
        System.out.print("a");
    }

    public B(){
        System.out.print("b");
    }
}
