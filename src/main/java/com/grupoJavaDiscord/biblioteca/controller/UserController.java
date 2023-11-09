package com.grupoJavaDiscord.biblioteca.controller;

import com.grupoJavaDiscord.biblioteca.service.UserService;
import com.grupoJavaDiscord.biblioteca.entity.User;
import com.grupoJavaDiscord.biblioteca.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    // public UserController(UserService userService) {
    //    this.userService = userService;
    //}

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllUsrs() {

        return userService.findAllUsers();
    }

    @GetMapping("/{cuser}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable Long cuser) {

        return userService.findUserById(cuser);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {

        return userService.saveUser(user);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody User user) {

        return userService.updateUser(user);
    }

    @DeleteMapping("/{cuser}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteUser(@PathVariable long cuser) {

        userService.deleteUser(cuser);
    }

}
