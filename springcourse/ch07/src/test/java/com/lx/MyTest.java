package com.lx;

import com.lx.dao.StudentDao;
import com.lx.domain.Student;
import com.lx.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MyTest {

    @Test
    public void test01(){

        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        String names[] = ctx.getBeanDefinitionNames();
        for(String na:names){
            System.out.println("容器中对象名称："+na+"|"+ctx.getBean(na));
        }
    }

    @Test
    public void testDaoInsert(){

        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentDao dao  = (StudentDao) ctx.getBean("studentDao");
        Student student  = new Student();
        student.setId(1013);
        student.setName("周锋");
        student.setEmail("zhoufeng@qq.com");
        student.setAge(20);
        int nums = dao.insertStudent(student);
        System.out.println("nums="+nums);
    }

    @Test
    public void testServiceInsert(){

        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentService service = (StudentService) ctx.getBean("studentService");
        Student student  = new Student();
        student.setId(1015);
        student.setName("李胜利");
        student.setEmail("zhoufeng@qq.com");
        student.setAge(26);
        int nums = service.addStudent(student);
        //spring和mybatis整合在一起使用，事务是自动提交的。 无需执行SqlSession.commit();
        System.out.println("nums="+nums);
    }

    @Test
    public void testServiceSelect(){

        String config="applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        //获取spring容器中的dao对象
        StudentService service = (StudentService) ctx.getBean("studentService");

        List<Student> students = service.queryStudents();
        for (Student stu:students){
            System.out.println(stu);
        }
    }
}
