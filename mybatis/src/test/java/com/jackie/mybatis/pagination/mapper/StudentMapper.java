package com.jackie.mybatis.pagination.mapper;

import com.jackie.mybatis.pagination.model.Student;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by jackie on 10/10/2016.
 */
public interface StudentMapper {
    List<Student> findAllStudents();
    List<Student> findAllStudents(RowBounds page);
    List<Student> findStudentByName(String name,RowBounds page);
}
