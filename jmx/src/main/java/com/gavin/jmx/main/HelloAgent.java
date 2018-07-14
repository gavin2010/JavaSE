package com.gavin.jmx.main;

import com.gavin.jmx.mbean.Hello;

import javax.management.JMException;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class HelloAgent {
    /**
     * 通过JConsole操作
     * @param args
     * @throws JMException
     * @throws Exception
     */
    public static void main(String[] args) throws JMException, Exception
    {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("jmxBean:name=hello");
        //注意：HELLO和HelloMBean必须在同一个包的同一层，接口以MBean结尾
        server.registerMBean(new Hello(), helloName);
        System.out.println("启动成功……");
        Thread.sleep(60*60*1000);
    }
}
