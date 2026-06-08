package com.example.studentapi;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    // 1. Simple Welcome GET API
    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to the Student Management REST API!";
    }

    // 2. GET endpoint returning student details
    @GetMapping("/details")
    public Student getStudentDetails() {
        Student stu = new Student();
        stu.setId(101);
        stu.setName("Yash Sharma");
        stu.setBranch("CSE");
        return stu;
    }

    // 3. POST endpoint accepting student data
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        return "Student received: " + student.getName() + ", Branch: " + student.getBranch();
    }
}