package com.samcodes.example.annotation_homework.models.enums;

public enum Extentions {
    TEXT(".txt"),
    JPEG(".jpg"),
    MPEG3(".mp3"),
    JAVA(".java");

    private final String value;

    Extentions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
