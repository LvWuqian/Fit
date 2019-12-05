package org.csu.fit.persistence;

import org.csu.fit.domain.User;

public interface UserMapper {

    User getUserByUsernameAndPassword(String username, String password);
}
