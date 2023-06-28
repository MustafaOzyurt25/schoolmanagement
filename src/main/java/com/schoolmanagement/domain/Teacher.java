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
public class Teacher extends User {

  

   

    @Column(unique = true)
    @Email(message = "Please Enter Valid Email")
    private String email;

    private  boolean isAdvisor;
  

    
    





   
}
