package com.studentSystem.StudentmanagementSystem.controller;

import com.studentSystem.StudentmanagementSystem.dto.StudentReq;
import com.studentSystem.StudentmanagementSystem.dto.StudentRes;
import com.studentSystem.StudentmanagementSystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentRes create(@RequestBody StudentReq req){
        return studentService.create(req);
    }

    @GetMapping
    public List<StudentRes>getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public StudentRes getById(@PathVariable Long id){
        return studentService.getById(id);
    }

    @PutMapping("/{id}")
    public StudentRes updateById(@PathVariable Long id,@RequestBody StudentReq req){
        return studentService.updateById(id,req);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        studentService.deleteById(id);
    }


}
