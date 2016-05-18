package com.jackie.hibernate.service.impl;

import com.jackie.hibernate.dao.UserDao;
import com.jackie.hibernate.model.User;
import com.jackie.hibernate.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
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
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = {NumberFormatException.class})
    public User updateUser(User user) {
        User updateUser = userDao.updateUser(user);
        return updateUser;
    }

    @Override
    @Transactional
    public User findUserByUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    @Transactional
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }
}
