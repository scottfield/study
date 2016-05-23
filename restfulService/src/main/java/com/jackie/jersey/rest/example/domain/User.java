package com.jackie.jersey.rest.example.domain;

import org.codehaus.jackson.map.annotate.JsonRootName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by jackie on 5/23/2016.
 */
@XmlRootElement
@JsonRootName("users")
public class User {
    private String username;
    private String email;
    @XmlElement(name = "name")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
