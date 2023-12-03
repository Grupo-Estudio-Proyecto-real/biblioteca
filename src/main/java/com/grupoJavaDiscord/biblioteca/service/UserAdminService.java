package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.dto.UserAdminDTO;

import java.util.List;

public interface UserAdminService {

    List<UserAdminDTO> findAllUser();
    UserAdminDTO findUserById(Long cuser);
    UserAdminDTO saveUser(UserAdminDTO userAdminDTO);
    UserAdminDTO updateUser(UserAdminDTO userAdminDTO, Long cuser);
    void deleteUser(Long cuser);
}
