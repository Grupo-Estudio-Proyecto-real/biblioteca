package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.entity.User;
import com.grupoJavaDiscord.biblioteca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public List<User>findAllUsers() {

        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findUserById(Long cuser) {

        return userRepository.findById(cuser).orElse(null);
    }

    @Override
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long cuser) {

        userRepository.deleteById(cuser);
    }
}
