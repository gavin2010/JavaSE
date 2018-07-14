package com.gavin.jmx.notifacation;

import com.gavin.jmx.mbean.Hello;
import com.gavin.jmx.mbean.Jack;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class HelloJackAgent {
    public static void main(String[] args) throws JMException, Exception
    {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("gavin:name=Hello");
        Hello hello=new Hello();
        server.registerMBean(hello, helloName);
        Jack jack = new Jack();
        server.registerMBean(jack, new ObjectName("jack:name=Jack"));
        jack.addNotificationListener(new HelloListener(), null, hello);
        Thread.sleep(500000);
    }
}
