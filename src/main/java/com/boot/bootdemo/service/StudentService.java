package com.boot.bootdemo.service;

import com.boot.bootdemo.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    void delStudent(Integer uid);
    Student findStudentById(Integer uid);
    void update(Student student);
    void add(Student student);
}
