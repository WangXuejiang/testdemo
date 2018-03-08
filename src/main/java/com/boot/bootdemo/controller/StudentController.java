package com.boot.bootdemo.controller;

import com.boot.bootdemo.domain.Student;
import com.boot.bootdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public String getAll(Model model){
        List<Student> list = studentService.getAll();
        model.addAttribute("students",list);
        return "index";
    }
    @GetMapping("/del")
    public String del(int id){
        studentService.delStudent(id);
        return "redirect:/all";
    }
    @GetMapping("/toUpdate")
    public String update(int id,Model model){
        Student student = studentService.findStudentById(id);
        model.addAttribute("student",student);
        return "update";
    }
    @PostMapping("/update")
    public String update(Student student,Model model){
        studentService.update(student);
        return "redirect:/all";
    }
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }

    @PostMapping("/add")
    public String update(Student student){
        studentService.add(student);
        return "redirect:/all";
    }
}
