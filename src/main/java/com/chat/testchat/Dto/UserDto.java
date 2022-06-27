package com.chat.testchat.Dto;

import com.chat.testchat.collections.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDto {
    private String id;
    private String userName;
    private String email;
    private List<String> contacts;
    private Boolean isLogged;
    private String ipAddress;
}
