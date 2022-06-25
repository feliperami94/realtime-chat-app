package com.chat.testchat.controller;

import com.chat.testchat.usecases.UserUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;
    private Logger logger = LoggerFactory.getLogger(UserController.class);
}
