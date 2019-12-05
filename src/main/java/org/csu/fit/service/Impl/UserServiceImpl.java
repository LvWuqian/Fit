package org.csu.fit.service.Impl;

import org.csu.fit.domain.User;
import org.csu.fit.persistence.UserMapper;
import org.csu.fit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, password);
    }
}
