package com.example.usertestproject.service;

import com.example.usertestproject.dto.UserDTO;
import com.example.usertestproject.dto.UserRequestDTO;
import com.example.usertestproject.entity.User;
import com.example.usertestproject.exception.ResourceNotFoundException;
import com.example.usertestproject.mapping.UserMapper;
import com.example.usertestproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO getUserById(ObjectId userId){
        User byId = userRepository.findById(userId.toString())
                .orElseThrow(() -> new ResourceNotFoundException("Not found user with user id: " + userId));
        return userMapper.toDTO(byId);
    }
    public UserDTO createUser(UserRequestDTO user){
        return userMapper.toDTO(userRepository.save(userMapper.toEntity(user)));
    }
    public UserDTO updateUser(ObjectId userId, UserRequestDTO userRequestDTO){
        User user1 = userRepository.findById(userId.toString())
                .map(user -> userMapper.updateUser(user, userRequestDTO))
                .orElseThrow(() -> new ResourceNotFoundException("Not found user with id: " + userId));
        return userMapper.toDTO(userRepository.save(user1));
    }
    public void deleteUser(ObjectId userId){
        User byId = userRepository.findById(userId.toString())
                .orElseThrow(() -> new ResourceNotFoundException("Not found user with user id: " + userId));
        userRepository.delete(byId);
    }
    public List<UserDTO> getAllUsers(){
        return userMapper.toDTO(userRepository.findAll());
    }
}
