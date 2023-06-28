package com.schoolmanagement.domain.enums;

public enum UserRole {

    ADMIN("Yonetici"), 
    TEACHER("Ogretmen"), 
    STUDENT("Ogrenci"), 
    DEAN("Mudur");

    private String displyName;

    UserRole(String displyName) {
        this.displyName = displyName;
    }

    public String getDisplyName() {
        return displyName;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "displyName='" + displyName + '\'' +
                '}';
    }
}
