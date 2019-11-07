package com.finger.desgin.prototype;

import java.io.Serializable;

public class Student implements Serializable {

    private String cls;

    private String grade;

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Student(){}

    public Student(String cls, String grade) {
        this.cls = cls;
        this.grade = grade;
    }
}
