package com.example.usertestproject.controller;

import com.example.usertestproject.dto.UserDTO;
import com.example.usertestproject.dto.UserRequestDTO;
import com.example.usertestproject.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;


    @Operation(summary = "Returns user of specified id")
    @GetMapping("/users/{userId}")
    public UserDTO getUserById(@PathVariable("userId")  ObjectId userId) {
        return userService.getUserById(userId);
    }

    @Operation(summary = "Create user with requested data")
    @PostMapping("/users/create")
    public UserDTO createUser(@RequestBody UserRequestDTO user) {
        return userService.createUser(user);
    }

    @Operation(summary = "Update user with requested data")
    @PutMapping("/users/{userId}")
    public UserDTO updateUser(@PathVariable("userId")  ObjectId userId, @RequestBody UserRequestDTO userRequestDTO) {
        return userService.updateUser(userId, userRequestDTO);
    }

    @Operation(summary = "Delete user by id")
    @DeleteMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("userId")  ObjectId userId) {
        userService.deleteUser(userId);
    }

    @Operation(summary = "Returns all users")
    @GetMapping("/users")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

}
