package com.jackie.jersey.rest.example;

import com.jackie.jersey.rest.example.domain.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Path("/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class JerseyRestDemo {
    private static final Logger LOGGER = Logger.getLogger(JerseyRestDemo.class);

    @GET
    public User getUser() {
        LOGGER.info("get user info");
        User user = new User();
        user.setUsername("jackie");
        user.setEmail("jackie@qq.com");
        return user;
    }

    @GET
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
    @Path("/add")
    public User addUser(User user) {
        return user;
    }
}
