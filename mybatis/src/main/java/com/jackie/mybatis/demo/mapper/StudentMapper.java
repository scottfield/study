package com.jackie.mybatis.demo.mapper;

import com.jackie.mybatis.demo.model.Student;

import java.util.List;

/**
 * Created by jackie on 10/10/2016.
 */
public interface StudentMapper {
    List<Student> findAllStudents();
}
