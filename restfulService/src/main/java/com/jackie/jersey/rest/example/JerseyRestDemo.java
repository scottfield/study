package com.jackie.jersey.rest.example;

import com.jackie.jersey.rest.example.domain.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jackie on 5/23/2016.
 */
@Path("/")
public class JerseyRestDemo {
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User getUser() {
        User user = new User();
        user.setUsername("jackie");
        user.setEmail("jackie@qq.com");
        return user;
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("list")
    public List<User> getUserList() {
        User jackie = new User();
        jackie.setUsername("jackie");
        jackie.setEmail("jackie@qq.com");
        User tom = new User();
        tom.setUsername("tom");
        tom.setEmail("tom@qq.com");
        List<User> list = new ArrayList<>();
        list.add(jackie);
        list.add(tom);
        return list;
    }

    @POST
    @Produces({MediaType.APPLICATION_ATOM_XML, MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/add")
    public User addUser(User user) {
        return user;
    }
}
