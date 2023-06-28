package com.schoolmanagement.domain;

import com.schoolmanagement.domain.enums.Gender;
import com.schoolmanagement.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass    //  @JoinedTable  @SingleTable

public abstract class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @NotBlank(message = "username can not be blank ")
    @Size(min = 3,max = 25,message = "username '${validatedValue}' must be between {min} and {max}")
    @Column(nullable = false,length = 25,unique = true)
    private String username;
   
   
   
    @NotBlank()
    @Column(unique = true)
    @Size(max = 11,min = 11)
    private String ssn;

    @NotBlank(message = "name can not be blank ")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "surname can not be blank ")
    @Column(nullable = false)
    private String surname;

    @NotBlank(message = "birtDay can not be blank ")
    @Past(message = "birtDay '${validatedValue}' must be in the past")
    private LocalDate birtDay;


    @NotBlank(message = "birtPlace is required ")
    private LocalDate birtPlace;


    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20, message = "Password length must be between 8 and 20")
    private String password;


    @NotBlank(message = "userRole is required")
    private UserRole userRole;

    @Column(unique = true)
    @NotBlank(message = "phoneNumber is required")
    @Size(min = 13, max = 13, message = "Password length must be between 8 and 20")
    private String phoneNumber;


    @NotBlank(message = "Gender is required")
    private Gender gender;

    
    
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirtDay() {
        return birtDay;
    }

    public void setBirtDay(LocalDate birtDay) {
        this.birtDay = birtDay;
    }

    public LocalDate getBirtPlace() {
        return birtPlace;
    }

    public void setBirtPlace(LocalDate birtPlace) {
        this.birtPlace = birtPlace;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                
                ", username='" + username + '\'' +
                ", ssn='" + ssn + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birtDay=" + birtDay +
                ", birtPlace=" + birtPlace +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                '}';
    }
}
