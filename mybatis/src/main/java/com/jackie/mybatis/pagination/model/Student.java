package com.jackie.mybatis.pagination.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by jackie on 10/10/2016.
 */
public class Student {
    private long studId;
    private String name;
    private String email;
    private LocalDate dob;
    private LocalDateTime lunchTime;

    public long getStudId() {
        return studId;
    }

    public void setStudId(long studId) {
        this.studId = studId;
    }

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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDateTime getLunchTime() {
        return lunchTime;
    }

    public void setLunchTime(LocalDateTime lunchTime) {
        this.lunchTime = lunchTime;
    }
}
