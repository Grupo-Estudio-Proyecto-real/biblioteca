package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.entity.User;
import java.util.List;

public interface UserService {

    List<User> findAllUsers();
    User findUserById(Long cuser);
    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(Long cuser);
}
