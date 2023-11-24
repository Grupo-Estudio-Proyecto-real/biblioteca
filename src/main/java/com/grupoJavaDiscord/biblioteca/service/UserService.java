package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.dto.UserDTO;
import com.grupoJavaDiscord.biblioteca.entity.User;
import java.util.List;

public interface UserService {

    List<UserDTO> findAllUsers();
    UserDTO findUserById(Long cuser);
    UserDTO saveUser(UserDTO userDTO);
    UserDTO updateUser(UserDTO userDTO, Long cuser);
    void deleteUser(Long cuser);
}
