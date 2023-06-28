package com.schoolmanagement.dto;

import com.schoolmanagement.domain.ContactMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespContactMessageDto {


    private String name;
    private String email;
    private String subject;
    private String message;
    private LocalDate date;


    public RespContactMessageDto(ContactMessage contactMessage) {
        this.name = contactMessage.getName();
        this.email = contactMessage.getEmail();
        this.subject = contactMessage.getSubject();
        this.message = contactMessage.getMessage();
        this.date=contactMessage.getDate();
    }


}