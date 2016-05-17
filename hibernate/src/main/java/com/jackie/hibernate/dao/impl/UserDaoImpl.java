package com.jackie.hibernate.dao.impl;

import com.jackie.hibernate.dao.UserDao;
import com.jackie.hibernate.model.User;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

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
    public void updateUser(User user) {
        template.merge(user);
    }

    @Override
    public User findUserByUsername(String username) {
        List<?> user = template.find("select user from User user where user.username=?", username);
        if (Objects.nonNull(user) && user.size() > 0) {
            return (User) user.get(0);
        }
        return null;
    }
}
