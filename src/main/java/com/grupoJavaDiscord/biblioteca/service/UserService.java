package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.entity.User;
import java.util.List;

public interface UserService {

    List<User> findAllUsers();
    User findUserId(Long cuser);
    User saveUser(User user);
    User updateUser(User user, Long cuser);
    void deleteUser(Long cuser);
}
