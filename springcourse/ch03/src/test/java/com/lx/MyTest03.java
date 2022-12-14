package com.lx;

import com.lx.bao03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {

    @Test
    public void test01(){
        String config="applicationContext03.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //从容器中获取对象
        Student student = (Student) ctx.getBean("myStudent");

        System.out.println("student="+student);
    }
}
