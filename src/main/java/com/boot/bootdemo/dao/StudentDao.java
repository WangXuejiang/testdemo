package com.boot.bootdemo.dao;

import com.boot.bootdemo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface StudentDao extends JpaRepository<Student,Integer>,JpaSpecificationExecutor<Student>{
    @Override
    List<Student> findAll();

}
