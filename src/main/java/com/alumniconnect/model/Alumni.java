package com.alumniconnect.model;

public class Alumni {
    private String name;
    private String email;
    private String batch;
    private String course; // optional, based on your controller example

    public Alumni() {
    }

    public Alumni(String name, String batch, String course, String email) {
        this.name = name;
        this.batch = batch;
        this.course = course;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
