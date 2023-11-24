package com.grupoJavaDiscord.biblioteca.controller;

import com.grupoJavaDiscord.biblioteca.dto.UserDTO;
import com.grupoJavaDiscord.biblioteca.exception.UserNotFoundException;
import com.grupoJavaDiscord.biblioteca.service.UserService;
import com.grupoJavaDiscord.biblioteca.entity.User;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/reader")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAllUsrs() {

        List<UserDTO> userDTOS = userService.findAllUsers();

        if (userDTOS.isEmpty()) {
            throw  new UserNotFoundException("No users found, the list is empty.");
        }

        return userDTOS;
    }

    @GetMapping("/{cuser}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findById(@PathVariable Long cuser) {

        Optional<UserDTO> user = Optional.ofNullable(userService.findUserById(cuser));

        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User with id is not found " + cuser);
        }
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO saveUser(@RequestBody @Valid UserDTO userDTO) {

        try {
            return userService.saveUser(userDTO);
        } catch (UserNotFoundException e) {
            throw new UserNotFoundException("User can´t create correctly");
        }

    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateUser(@RequestBody @Valid UserDTO userDTO, Long cuser) {

        Optional<UserDTO> existingUser = Optional.ofNullable(userService.findUserById(cuser));

        try {
            if (existingUser.isEmpty()) {
                throw new UserNotFoundException("User with id is not found " + cuser);
            }
            return userService.updateUser(userDTO, cuser);

        } catch (UserNotFoundException e) {
            throw new UserNotFoundException("User can´t update correctly");
        }

    }

    @DeleteMapping("/{cuser}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteUser(@PathVariable long cuser) {

        Optional<UserDTO> existingUser = Optional.ofNullable(userService.findUserById(cuser));

        if(existingUser.isEmpty()) {
            throw new UserNotFoundException("User with id is not found " + cuser);
        }

        userService.deleteUser(cuser);
    }

}
