package com.studentSystem.StudentmanagementSystem.service;

import com.studentSystem.StudentmanagementSystem.dto.StudentReq;
import com.studentSystem.StudentmanagementSystem.dto.StudentRes;
import com.studentSystem.StudentmanagementSystem.model.Student;

import java.util.List;

public interface StudentService {
    //create
    public StudentRes create(StudentReq req);

    //read
    public List<StudentRes> getAllStudent();

    public StudentRes getById(Long id);

    //update
    public StudentRes updateById(Long id, StudentReq req);

    //delete
    public void deleteById(Long id);



}
