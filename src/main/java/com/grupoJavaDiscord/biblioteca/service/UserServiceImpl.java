package com.grupoJavaDiscord.biblioteca.service;

import com.grupoJavaDiscord.biblioteca.dto.UserDTO;
import com.grupoJavaDiscord.biblioteca.dto.map.MapToDTO;
import com.grupoJavaDiscord.biblioteca.entity.User;
import com.grupoJavaDiscord.biblioteca.exception.UserNotFoundException;
import com.grupoJavaDiscord.biblioteca.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> findAllUsers() {

        List<User> users = (List<User>) userRepository.findAll();

        return users.stream()
                .map(MapToDTO::mapUserToDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO findUserById(Long cuser) {

        Optional<User> existingUser = userRepository.findById(cuser);

        return existingUser.map(MapToDTO::mapUserToDTO)
                .orElseThrow(() -> new UserNotFoundException(" User not found because this id no exist"));

    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {

        User user = User.builder()
                .name(userDTO.getName())
                .surnames(userDTO.getSurnames())
                .address(userDTO.getAddress())
                .phone(userDTO.getPhone())
                .email(userDTO.getEmail())
                .build();

        return MapToDTO.mapUserToDTO(userRepository.save(user));

    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long cuser) {

        Optional<User> existingUser = userRepository.findById(cuser);

        User user = existingUser.orElse(null);

        user.setName(userDTO.getName());
        user.setSurnames(userDTO.getSurnames());
        user.setAddress(userDTO.getAddress());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());

        return MapToDTO.mapUserToDTO(userRepository.save(user));

    }

    @Override
    public void deleteUser(Long cuser) {

        userRepository.deleteById(cuser);
    }
}
