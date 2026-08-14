package com.studentSystem.StudentmanagementSystem.repository;

import com.studentSystem.StudentmanagementSystem.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//YE DATABASE KI TARAH KAAM KAREGA
@Repository
public class StudentRepo {
    private final List<Student>students = new ArrayList<>();

    private Long idCounter = 1L;

    public Student save(Student student){
        if(student.getId() == null){
            student.setId(idCounter++);
            students.add(student);
        }
        else{
            deleteById(student.getId());
            students.add(student);
        }
        return student;
    }

    public List<Student> findAll(){
        return students;
    }

    public Optional<Student>findById(Long id){
        return students.stream().filter(student -> student.getId().equals(id)).findFirst();
    }

   public void deleteById(Long id){
        students.removeIf(student ->student.getId().equals(id));
    }




}
