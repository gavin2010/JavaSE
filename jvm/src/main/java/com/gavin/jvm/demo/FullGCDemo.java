package com.gavin.jvm.gc;

import java.util.ArrayList;
import java.util.List;

class Person{
    private String name;
    private String age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
}

/**
 * -Xms100M -Xmx100M -Xss128k -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC -Xloggc:h:/gclogs
 *
 */
public class FullGCDemo {

    public static void main(String[] args) throws Exception {
        List<Person> persons = new ArrayList<Person>();
        long start = 0L;
        long end = 0L;
        long runtime = 0L;
        int count = 0;
        while(count<100000) {
            start = System.currentTimeMillis();
           /* Person p = new Person();
            p.setName("小米");
            persons.add(p);*/

            persons.add(new Person());
          /*  new Person();
            count++;
            end = System.currentTimeMillis();
            runtime = end - start;
            System.out.println(count + " : Use time in one operation:" + runtime + "ms");
            start = end;*/

           // Thread.sleep(50);
        /*    Class.forName("com.gavin.jvm.gc.Person").newInstance();
            System.out.println(count++);*/
        }
    }
}
