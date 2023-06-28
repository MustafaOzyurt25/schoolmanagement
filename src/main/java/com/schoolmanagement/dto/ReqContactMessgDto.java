package com.schoolmanagement.dto;

import com.schoolmanagement.domain.ContactMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReqContactMessgDto {


    @NotNull
    private String name;

    @NotNull
    @Email(message = "Please provide valid email")
    private String email;


    private String subject;

    private String message;


    public ReqContactMessgDto(ContactMessage contactMessage) {
        this.name = contactMessage.getName();
        this.email = contactMessage.getEmail();
        this.subject = contactMessage.getSubject();
        this.message = contactMessage.getMessage();

    }
}
