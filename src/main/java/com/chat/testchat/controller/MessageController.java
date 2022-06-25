package com.chat.testchat.controller;

import com.chat.testchat.usecases.MessageUseCase;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class MessageController {

    private final MessageUseCase messageUseCase;
    private static Logger logger = LoggerFactory.getLogger(MessageController.class);
}
