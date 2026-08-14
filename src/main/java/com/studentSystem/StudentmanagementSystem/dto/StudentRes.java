package com.studentSystem.StudentmanagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRes {
    private Long id;
    private String name;
    private String email;
    private String course;
}
