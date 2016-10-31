package com.jackie.mybatis.demo.model;

import java.util.Date;

/**
 * Created by jackie on 10/10/2016.
 */
public class Student {
    private long studId;
    private String name;
    private String email;
    private Date dob;

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
