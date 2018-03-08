package com.boot.bootdemo.service;

import com.boot.bootdemo.dao.StudentDao;
import com.boot.bootdemo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements  StudentService{
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> getAll() {
        return studentDao.findAll();
    }

    @Override
    public void delStudent(Integer uid) {
        studentDao.delete(uid);
    }

    @Override
    public Student findStudentById(Integer uid) {
        return studentDao.findOne(uid);
    }

    @Override
    public void update(Student student) {
        studentDao.save(student);
    }

    @Override
    public void add(Student student) {
        studentDao.save(student);
    }


}
