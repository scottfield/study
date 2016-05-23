package com.jackie.hibernate.service;

import com.jackie.hibernate.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

/**
 * Created by jackie on 5/13/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:/applicationcontext.xml"})
public class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void addUser() throws Exception {
        User user = new User();
        user.setUsername("jackie");
        user.setPassword("password");
        assertNull(user.getId());
        userService.addUser(user);
        assertNotNull(user.getId());
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() throws Exception {
        User jackie = userService.findUserById(21L);
        jackie.setUsername("jackies");
        jackie.setPassword("passwordchange");
        userService.updateUser(jackie);
    }
}