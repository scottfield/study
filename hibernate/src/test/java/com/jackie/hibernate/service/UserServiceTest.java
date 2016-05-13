package com.jackie.hibernate.service;

import com.jackie.hibernate.model.User;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Log4jConfigurer;

import javax.annotation.Resource;
import java.io.FileNotFoundException;

/**
 * Created by jackie on 5/13/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:/applicationcontext.xml"})
public class UserServiceTest {
    @BeforeClass
    public static void init() throws FileNotFoundException {
        Log4jConfigurer.initLogging("classpath:log4.properties");
    }

    @Resource
    private UserService userService;
    private Logger logger = Logger.getLogger(UserServiceTest.class);

    @Test
    public void addUser() throws Exception {
        logger.info("save user");
        User user = new User();
        user.setUsername("jackie");
        user.setPassword("password");
        userService.addUser(user);
    }
}