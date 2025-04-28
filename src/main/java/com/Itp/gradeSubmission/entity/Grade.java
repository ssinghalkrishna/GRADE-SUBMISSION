package com.Itp.gradeSubmission.entity;

import jakarta.persistence.*;

import java.util.UUID;

public class Grade {

    private String id;

    public Grade() {
  //      this.id = UUID.randomUUID().toString();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "subject")
    private String subject;

    @Column(name = "score")
    private String score;

    public Grade(String name, String subject, String score) {
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public Grade(String id, String name, String subject, String score) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getScore() {
        return score;
    }
}
