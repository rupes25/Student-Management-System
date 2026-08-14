package com.studentSystem.StudentmanagementSystem.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class StudentReq {
    private String firstName;
    private String lastName;
    private String email;
    private String department;
}
