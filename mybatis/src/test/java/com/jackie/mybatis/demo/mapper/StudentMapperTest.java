package com.jackie.mybatis.demo.mapper;

import com.jackie.mybatis.demo.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

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
        List<Student> allStudents = studentMapper.findAllStudents();
        System.out.println(allStudents);
    }

}