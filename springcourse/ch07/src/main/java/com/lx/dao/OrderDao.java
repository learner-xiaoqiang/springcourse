package com.lx.dao;

import com.lx.domain.Student;

import java.util.List;

public interface OrderDao {

    int insertStudent(Student student);
    List<Student> selectStudents();

}
