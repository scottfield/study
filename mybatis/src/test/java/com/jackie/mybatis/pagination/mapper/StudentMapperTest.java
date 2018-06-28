package com.jackie.mybatis.pagination.mapper;

import com.jackie.mybatis.pagination.model.Student;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.rmi.StubNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by jackie on 10/10/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void findAllStudents() throws Exception {
        RowBounds page = new RowBounds(0, 1);
        List<Student> allStudents = studentMapper.findAllStudents(page);
        System.out.println(allStudents);
    }

    @Test
    public void findAllStudentsByName() throws Exception {
        RowBounds page = new RowBounds(0, 1);
        List<Student> allStudents = studentMapper.findStudentByName("%Stude%", page);
        System.out.println(allStudents);
    }

    @Test
    public void testStringTokenizer() throws Exception {
        StringTokenizer tokenizer = new StringTokenizer("hell;ddk,dkdkd", ";,");
        while (tokenizer.hasMoreTokens()) {
            String s = tokenizer.nextToken();
            System.out.println(s);
        }
    }

    @Test
    public void testAddStudent() throws Exception {
        Student student = new Student();
        student.setName("jackiew");
        student.setEmail("jackiew@qq.com");
        student.setDob(LocalDate.now());
        student.setLunchTime(LocalDateTime.now());
        studentMapper.addStudent(student);
    }
}