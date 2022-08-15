package com.example.usertestproject.mapping;

import com.example.usertestproject.dto.UserDTO;
import com.example.usertestproject.dto.UserRequestDTO;
import com.example.usertestproject.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequestDTO userDTO);
    @Mapping(target = "userId", source = "id")
    UserDTO toDTO(User user);
    User updateUser(@MappingTarget User user, UserRequestDTO userRequestDTO);
    @Mapping(target = "userId", source = "id")
    List<UserDTO> toDTO(List<User> all);
}
