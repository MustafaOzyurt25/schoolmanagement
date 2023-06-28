package com.schoolmanagement.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.schoolmanagement.dto.ReqContactMessgDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor   // @Data hepsini karsilamiyor(!)
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;

    @NotNull(message = "name can not be null")
    @Column(nullable = false)
    private String name;
    
    @NotNull
    @Email(message = "mail adresine uygun formatta yazilmali")
    @Column(nullable = false)
    private String email;

    
    private String subject;

    private String message;

    @JsonFormat(pattern="yyyy-MM-dd")
   // @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date=LocalDate.now();

    //bunu kullandik mi?
    public ContactMessage(ReqContactMessgDto reqContactMessgDto) {
        this.name=reqContactMessgDto.getName();
        this.email=reqContactMessgDto.getEmail();
        this.subject=reqContactMessgDto.getSubject();
        this.message=reqContactMessgDto.getMessage();
    }
    
}
