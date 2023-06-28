package com.schoolmanagement.domain.enums;

public enum Gender {


    MALE("Erkek"),
    FEMALE("Kadın");

    private String displayName;

    Gender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "displayName='" + displayName + '\'' +
                '}';
    }
}
