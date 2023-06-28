package com.schoolmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student extends  User {

    @Column(unique = true)
    @Email(message = "Please Enter Valid Email")
    private String  email;

    private  Boolean isActive;
    
    private String motherName;

    private String fatherName;
    
    private int studentNumber;
    
}
