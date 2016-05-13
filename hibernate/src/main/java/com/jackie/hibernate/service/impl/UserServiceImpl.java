package com.jackie.hibernate.service.impl;

import com.jackie.hibernate.dao.UserDao;
import com.jackie.hibernate.model.User;
import com.jackie.hibernate.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;

/**
 * Created by jackie on 5/13/2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    @Transactional(rollbackFor = {RuntimeErrorException.class})
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
