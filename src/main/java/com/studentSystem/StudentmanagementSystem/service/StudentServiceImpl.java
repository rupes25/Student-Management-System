package com.studentSystem.StudentmanagementSystem.service;

import com.studentSystem.StudentmanagementSystem.dto.StudentReq;
import com.studentSystem.StudentmanagementSystem.dto.StudentRes;
import com.studentSystem.StudentmanagementSystem.exception.ResourceNotFoundException;
import com.studentSystem.StudentmanagementSystem.model.Student;
import com.studentSystem.StudentmanagementSystem.repository.StudentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepo studentRepo;

    @Override
    public StudentRes create(StudentReq req) {
        Student student = new Student(
                null,
                req.getName(),
                req.getEmail(),
                req.getCourse()
        );
        Student saved = studentRepo.save(student);
        return new StudentRes(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getCourse()
        );
    }

    @Override
    public List<StudentRes> getAllStudent() {
        return studentRepo.findAll()
                .stream()
                .map(student -> new StudentRes(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse()
        ))
                .collect(Collectors.toList());
    }

    @Override
    public StudentRes getById(Long id) {
        Student student = studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("No student Found"));
        return new StudentRes(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse()
        );
    }

    @Override
    public StudentRes updateById(Long id, StudentReq req) {
        Student student = studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("No student Found"));
        student.setName(student.getName());
        student.setEmail(student.getEmail());
        student.setCourse(student.getCourse());

        return new StudentRes(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse()
        );
    }

    @Override
    public void deleteById(Long id) {
        studentRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("No student Found"));
        studentRepo.deleteById(id);

    }
}
