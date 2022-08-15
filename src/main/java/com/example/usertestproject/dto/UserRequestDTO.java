package com.example.usertestproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserRequestDTO {

    private String email;

    private String firstName;

    private String lastName;
}
