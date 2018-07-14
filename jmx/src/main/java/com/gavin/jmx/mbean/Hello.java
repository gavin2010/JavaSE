package com.gavin.jmx.mbean;

public class Hello implements HelloMBean {
    private String age = "123";
    private String name = "tom";

    public void getTelephone()
    {
        System.out.println("get Telephone");
    }

    public void helloWorld()
    {
        System.out.println("hello world");
    }

    public void helloWorld(String str)
    {
        System.out.println("helloWorld:" + str);
    }

    @Override
    public void printHello(String hiname) {
        System.out.println("Hello, "+ hiname);
    }

    public String getName()
    {
        System.out.println("get name "+name);
        return name;
    }

    public void setName(String name)
    {
        System.out.println("set name "+name);
        this.name = name;
    }

    public String getAge()
    {
        System.out.println("get age "+age);
        return age;
    }

    public void setAge(String age)
    {
        System.out.println("set age "+age);
        this.age = age;
    }

}
