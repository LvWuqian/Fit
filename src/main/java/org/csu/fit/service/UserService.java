package org.csu.fit.service;

import org.csu.fit.domain.User;

public interface UserService {
    public User login(String username, String password);
}
