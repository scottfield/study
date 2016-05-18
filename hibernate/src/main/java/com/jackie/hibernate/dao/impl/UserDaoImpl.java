package com.jackie.hibernate.dao.impl;

import com.jackie.hibernate.dao.UserDao;
import com.jackie.hibernate.model.User;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by jackie on 5/13/2016.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Resource
    private HibernateTemplate template;

    @Override
    public void addUser(User user) {
        template.persist(user);
    }

    @Override
    public User updateUser(User user) {
        return template.merge(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return (User) template.findByNamedParam("select user from User user where user.username=:username", "username", username).get(0);
    }

    @Override
    public User findUserById(Long id) {
        return template.get(User.class, id);
    }
}
