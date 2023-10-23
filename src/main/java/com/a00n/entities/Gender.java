package com.a00n.entities;

public enum Gender {
    FEMALE("F"),
    MALE("M");

    private final String code;

    private Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
