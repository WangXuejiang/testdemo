package com.boot.bootdemo.controller;

import com.boot.bootdemo.dao.StudentDao;
import com.boot.bootdemo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Controller
public class LoginController {
    @Autowired
    private StudentDao studentDao;
    @RequestMapping("/user/login_view")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/user/login")
    public String login(Student student){
        String result="登陆成功";
        Student one = studentDao.findOne(new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                query.where(cb.equal(root.get("name"), student.getUsername()));
                return null;
            }
        });
        if (one == null) {
            result="用户不存在";
        }else if(one.getPassword().equals(student.getPassword())){
            result="密码错误";
        }
        return result;
    }
    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }

}
